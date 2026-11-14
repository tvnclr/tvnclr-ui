# AGENTS.md — tvnclr-ui

Instructions for any coding agent or tool working on this repository (Claude Code reads it through `CLAUDE.md`). Personal setup of the maintainer's machine lives in `AGENTS.local.md`, which is not versioned; read it too when it exists.

## What this is
The Jetpack Compose design system shared by the tvnclr Android apps ([OTPilot](https://github.com/tvnclr/OTPilot), [Slap](https://github.com/tvnclr/Slap)). Package `dev.tvnclr.ui`, components prefixed with `Tv`, theme `TvnclrTheme`. GPL-3.0. Apps include it as a git submodule pinned to a tag.

## Branches and versions
- `dev`: work in progress.
- `main`: tagged releases only (`vX.Y.Z`). Apps bump their submodule to a tag, never to a branch.
- Release flow: merge `dev` into `main`, tag, push, then bump the submodule in each app in its own commit.

## Layout
- `Tokens.kt` — spacing grid (`TvSpace`), shapes (`TvShape`), type scale (`TvType`), motion (`TvMotion`).
- `Palette.kt` — theme modes, the 8 accents (`TvAccent`), neutral colors per theme, `onColorFor`.
- `Theme.kt` — `TvnclrTheme`, Material You mapping, `Tv.colors`.
- `Components.kt`, `Extras.kt` — every component (page scaffolding, sections, rows, buttons, pickers, dialogs, menus, fields).
- `Background.kt` — animated backgrounds (Orbs, Aurora, Horizon, Radar, Depth, None); everything freezes when the system removes animations.
- `Prefs.kt` — stores the user's theme choices.
- `res/values*/tvnclr_ui_strings.xml` — the library's strings in every shipped locale.

## Build and test
There is no standalone Gradle project: build through an app that includes `:tvnclr-ui` (both apps do).
- `gradlew :tvnclr-ui:testDebugUnitTest` — JVM tests (`OnColorTest`).
- A string added here needs every locale in `res/values*/` with the same format arguments; the apps' translation tests check the library's strings too.

## Rules
- Text on an accent fill always comes from `onColorFor`, which picks `#15131C` or white by the higher contrast. `OnColorTest` fails if any accent tone drops under 4.5:1; keep it passing when an accent changes.
- Values follow the tvnclr design system (spacing 2/4/8/12/16/24/32, radii 22/14/12/pill, the type scale). Do not add one-off values.
- A component an app needs goes here, not into the app.
- Mono and code styles stay left-to-right; prose styles hyphenate.

## Do not
- Push to `main` outside a release, move or delete tags.
- Change `README.md` without the owner asking: it is the public page.

## State
- `v1.0.3` released: text on accent fills by contrast, `OnColorTest`. OTPilot and Slap pin it.

## Next step
See the top entry of `CHANGELOG.md`.