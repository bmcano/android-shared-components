# UI Spacing & Padding Guide

**Applies to:** Calculator Screens and Information Screens in all mobile apps\
**Matieral Design:** Jetpack Compose with Material 3 components


## Global Layout Padding

- **Horizontal padding:** 
  - `16.dp` - `values/dimnes.xml` - Phones
  - `184.dp` - `values-sw720dp/dimens.xml` - Tablets and Desktops
- **Top padding:** 
  - `32.dp` if first element is an image
  - `24.dp` otherwise
- **Bottom padding:**
  - `48.dp` if no bottom navigation bar
  - `24.dp` if bottom navigation bar is present

### First Element Top Spacing

Depending on the **first content** element in the screen, use:

| First Element Type  | Top Spacing from Screen Edge |
|---------------------|------------------------------|
| Image (Hero/Visual) | `32.dp`                      |
| Headline Text       | `24.dp`                      |
| Text Field          | `24.dp`                      |
| Dropdown / Selector | `24.dp`                      |


### Spacing Between Elements - WIP

| Between Elements                        | Spacing |
|-----------------------------------------|---------|
| Section title → next content block      | `24.dp` |
| Title → paragraph text                  | `8.dp`  |
| Paragraphs / blocks of text             | `12.dp` |
| Form fields (TextField, Dropdown)       | `12.dp` |
| Between icon and accompanying text      | `8.dp`  |
| Between buttons (horizontal or stacked) | `12.dp` |


## Code Patterns

### Navigation Transitions

In our `NavEntry` files we define the routes and their enter and exit transitions.
In general, we only have three screen types to consider for my calculator apps.
- Landing (home) screens
- Calculator screens
- Informational screens

For the landing or home screen, the transitions should be as follows:

```kotlin
composable(
    route = "route",
    enterTransition = { EnterTransition.None },
    exitTransition = { ExitTransition.None },
)
```

For any calculator screens we want the patterns for be as follows

```kotlin
composable(
    route = "route",
    enterTransition = { slideInVertically(initialOffsetY = { it }) },
    exitTransition = { ExitTransition.None },
    popEnterTransition = { EnterTransition.None },
    popExitTransition = { slideOutVertically(targetOffsetY= { it }) },
) 
```

For any non-calculator screens, like info or about, we want the patterns for be as follows

```kotlin
composable(
    route = "route",
    enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
    exitTransition = { ExitTransition.None },
    popEnterTransition = { EnterTransition.None },
    popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
)
```

### Scaffold

### Scrollable Column

### Calculator Screens

### Input & Visual Blocks

- **Fields (TextField/Dropdown):** `Spacer(Modifier.height(16.dp))`
- **Resistor/Capacitor visuals:**
  - Top: `24.dp`
  - Bottom before next block: `16.dp`

### Action Buttons (CTA)

- Top spacing before buttons: `24.dp`
- Bottom spacing:
  - `48.dp` if no nav bar
  - `24.dp` if nav bar is present


## Information Screens

### Title / Header Block

- Top: `24.dp`
- Bottom before body text: `16.dp`

### Body Text

- Use `MaterialTheme.typography.bodyLarge`
- Use `Spacer(Modifier.height(16.dp))` between paragraphs
- Use `Spacer(Modifier.height(24.dp))` between sections

### Tables / Bullet Lists

- Inner cell padding: `12.dp`–`16.dp`
- Row spacing: `8.dp`

### Icons / Diagrams

- Padding from surrounding text: `16.dp`
- Bottom spacing before next block: `24.dp`

---

## Additional Tips

- **Responsiveness:** Use `WindowSizeClass` or responsive paddings
- **Spacing tokens:** Prefer `Arrangement.spacedBy()` and `Spacer()`
- **Avoid hardcoded values across files:** Centralize with `dimensionResource()` or theme extension constants

