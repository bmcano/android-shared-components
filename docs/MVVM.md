# MVVM Architecture Guide for Mobile Apps

**Applies to:** All calculator and information apps using Jetpack Compose, StateFlow, and a shared architecture.

## Overview

Our MVVM implementation provides a clean, testable, and maintainable structure. It separates UI concerns from business logic and shared infrastructure like preferences and repositories. It also enables screen reuse and minimizes boilerplate across the suite of calculator and utility apps.

## Core Principles

- **Unidirectional data flow:** State flows from the ViewModel to the UI
- **State preservation:** Shared Preferences are wrapped in a repository layer
- **Separation of concerns:** UI ↔ ViewModel ↔ Repository
- **Consistency:** Standard TO (transfer object) data classes are used for state

## Architectural Components

### ViewModel

The ViewModel is responsible for:
- Holding UI state (`StateFlow`)
- Dispatching updates to the repository
- Business logic and validation

```kotlin
class ResistorVtcViewModel(
    private val repository: ResistorRepository
) : ViewModel() {

    private val _resistorState = MutableStateFlow(ResistorVtc())
    val resistorStateTOStateFlow: StateFlow<ResistorVtc> = _resistorState

    fun updateValues(...) { /* ... */ }
    fun updateCardContent(...) { /* ... */ }
    fun clear() { /* ... */ }
}
```

### Repository
Encapsulates SharedPreferences or other persistent mechanisms.

```kotlin
class ResistorRepository(private val prefs: SharedPreferences) {
    fun saveResistor(resistor: ResistorVtc) { /* JSON encode and store */ }
    fun loadResistor(): ResistorVtc { /* JSON decode from storage */ }
    fun clear() { prefs.edit().clear().apply() }
}
```

### TO (Transfer Object)
Encodes full screen state in a serializable format.

```kotlin
data class ResistorVtc(
    var resistance: String = "",
    var units: String = "Ohm",
    var band5: String = "",
    var band6: String = "",
    var navBarSelection: Int = 0
) : Serializable {
    fun isEmpty(): Boolean = resistance.isEmpty() || band5.isEmpty()
    fun formatResistor() { /* UI formatting */ }
}
```

---

## Navigation Entry Pattern

All screens use dedicated functions in the `NavGraphBuilder`, with transitions, state setup, and a wrapper route composable:

```kotlin
fun NavGraphBuilder.valueToColorScreen(navHostController: NavHostController) {
    composable(
        route = Screen.ValueToColor.route,
        enterTransition = { slideInHorizontally { it } },
        exitTransition = { slideOutHorizontally { -it } },
        popEnterTransition = { slideInHorizontally { -it } },
        popExitTransition = { slideOutHorizontally { it } },
    ) {
        ValueToColorRoute(navHostController)
    }
}
```

### `ValueToColorRoute()` Example

```kotlin
@Composable
fun ValueToColorRoute(navHostController: NavHostController) {
    val context = LocalContext.current
    val viewModel: ResistorVtcViewModel = viewModel(factory = ResistorViewModelFactory(context))
    val resistor by viewModel.resistorStateTOStateFlow.collectAsState()

    ValueToColorScreen(
        resistor = resistor,
        onNavigateBack = { navHostController.popBackStack() },
        onValueChanged = viewModel::updateValues,
        // other lambdas and UI wiring
    )
}
```

---

## ViewModel Instantiation Pattern
Use a `ViewModelFactory` that injects repositories:

```kotlin
class ResistorViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val prefs = context.getSharedPreferences("resistor_prefs", Context.MODE_PRIVATE)
        val repository = ResistorRepository(prefs)
        return ResistorVtcViewModel(repository) as T
    }
}
```

---

## Summary of Benefits
- ✅ Clean separation of logic
- ✅ Testable ViewModels
- ✅ Easily portable TO-based state objects
- ✅ Decoupled UI and persistence layers
- ✅ Consistent state management via StateFlow

Use this document as a reference when building any new screen, ensuring reusability and architectural alignment across apps.

