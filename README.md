# tvnclr-ui

The Compose design system shared by tvnclr's Android apps ([OTPilot](https://github.com/tvnclr/OTPilot), [Slap](https://github.com/tvnclr/Slap)).

Package `dev.tvnclr.ui`, components prefixed with `Tv`.

## What's inside

- **Tokens:** 4/8 spacing grid, fixed type scale, shapes, motion (`TvSpace`, `TvType`, `TvShape`, `TvMotion`).
- **Themes:** System, Light, Dark and AMOLED; 8 accent colors or Material You (Android 12+). `TvnclrTheme` applies them; `TvThemePrefs` stores the user's choice.
- **Components:** top bar, page, section, outlined card, rows (with chevron or switch), status pill, buttons, segmented control, chips, accent dots, text and search fields, dialogs, menus, empty state, callout, code block.
- **Animated backgrounds:** Orbs, Aurora, Horizon, Radar, Depth and None. They freeze when the system "Remove animations" setting is on.
- **Strings:** English and Portuguese (Brazil).

## Use in an app

Add it as a git submodule at the root of the app project and include the module:

```
git submodule add https://github.com/tvnclr/tvnclr-ui.git tvnclr-ui
```

```kotlin
// settings.gradle.kts
include(":tvnclr-ui")

// app/build.gradle.kts
dependencies { implementation(project(":tvnclr-ui")) }
```

Each app pins the submodule to a tagged version; updating it is a deliberate commit in the app.

## License

GPL-3.0. See [LICENSE](LICENSE).