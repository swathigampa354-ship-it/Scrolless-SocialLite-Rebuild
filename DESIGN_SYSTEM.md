# Design System

## Typography
- `ScrollessTypography` uses the Google Sans Flex variable font, license SIL OFL v1.1.
- Primary Compose font family: `GoogleSansFlex`.
- Variants: regular, medium, semi-bold, bold via `FontVariation.weight(...)`; no separate OTFs.
- SocialLite reference assets include DM Sans TTFs (`dm_sans_regular`, `dm_sans_medium`, `dm_sans_semibold`, `dm_sans_bold`).

## Colors
- SocialLite `socialPrimary`: `#FF80CBC4`; `socialPrimaryVariant`: `#FF65A19B`.
- SocialLite `socialOnPrimary`: `#FFFFFFFF`.
- SocialLite `socialSecondary`: `#FF80C3BD`.
- SocialLite `socialSurface`: `#FFFFFFFF`; `socialOnSurface`: `#FF1A1C1B`; `socialBackground`: `#FFE8EEED`; `socialOnBackground`: `#FF191C1B`; `socialError`: `#FFD35400`.
- XML `themes.xml` now uses `@color/social_primary` and `@color/social_secondary`; `colors.xml` contains the referenced colors.

## Layout / Controls
- App bar `56dp`, rounded control radius `2dp`, buttons min height `48dp`, cards `2dp` radius/elevation.
- Dark mode: `Color.kt` defines Scrolless brand-dark tokens: `backgroundDark = #FF111318`, `primaryDark = #FFAAC7FF`, `onSurfaceVariantDark = #FFC4C6D0`, `timerOverlayBackgroundColor = #B3000000`.
- Shared transition local: `LocalSharedTransitionScope`; theme entry: `ScrollessTheme(darkTheme, dynamicColor, content)` in `core/designsystem/theme/Theme.kt`.

## Status
- App-package design tokens exist in `core/designsystem/theme/` and `core/designsystem/util/`; no duplicate app-package designsystem files were required.
- User baseline palette for first SocialLite design pass: Primary `#80CBC4`, Secondary `#80C3BD`, light bg `#E8EEED`, light surface `#FFFFFF`, dark bg `#212121`, dark surface `#424242`, error `#D35400`; deviations are to be marked `VERIFIED/OBSERVED/INFERRED/UNKNOWN` and only as proposed values in this doc or XML.
