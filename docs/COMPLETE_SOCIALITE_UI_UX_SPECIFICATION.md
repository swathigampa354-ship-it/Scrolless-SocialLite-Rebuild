# COMPLETE SOCIALITE UI/UX DESIGN HANDOVER SPECIFICATION

Source repository: <https://github.com/swathigampa354-ship-it/sociallite-re-findings>

This document is an extraction of every recoverable UI/UX detail from the SocialLite Android application. It is organized for another developer or AI coding agent to reconstruct the application interface without repeatedly analyzing the original APK.

Classifications used throughout:

- **VERIFIED**: recovered directly from resources, source, or bytecode.
- **INFERRED**: estimated from available evidence and marked as such.
- **NOT RECOVERED**: could not be recovered from static artifacts.

---

## 1. Executive Summary

- Android package: `com.sociallite.android`; app name `SocialLite`; versionCode `262`.
- Dominant app family: Material Light with dark-mode support, DM Sans font family, teal accent (`#80CBC4`), white surfaces, and Material 3 Compose UI.
- Primary screens verified from strings/routes: Splash, Welcome, Onboarding Introduction/Question/Finish, Home, Blocking, Settings, Help/Tutorial, Permission setup, Blocked App Overlay, Timer Focus, Usage Stats.
- Font: DM Sans, weights Regular/Medium/Semibold/Bold.
- Main colour palette: `#80CBC4` primary, `#424242` background, `#212121` dark background, `#1877F2` Facebook blue, `#0084FF` Messenger blue.
- Animation system: Material default fade/scale/slide animations plus custom checkbox/radio/fragment animators.

---

## 2. Typography Specification

### 2.1 Font Families

| ID | File | Source |
|---|---|---|
| DM Sans | `apktool_full/res/font/dm_sans_regular.ttf`, `apktool_full/res/font/dm_sans_medium.ttf`, `apktool_full/res/font/dm_sans_semibold.ttf`, `apktool_full/res/font/dm_sans_bold.ttf` | VERIFIED |

Weights and filenames are from `apktool_full/res/values/public.xml:717-720`.

### 2.2 Style Tokens

Use the extracted Material 3 theme styles as canonical fallbacks when SocialLite-specific sizes are NOT RECOVERED.

Key verified styles:

- `Theme.SocialLite` — `apktool_full/res/values/styles.xml:576-584`
- `Theme.SocialLite.Blocked` — `styles.xml:585-589`
- `Theme.SocialLite.WebViewDark` — `styles.xml:590`

Extracted compact colors and font tokens are listed in section 4.

### 2.3 Text Styles

| Style | Status | Recovery notes |
|---|---|---|
| Headline/Display | INFERRED | Material `headlineMedium/Large` used in SocialLite strings; no custom size found. |
| Title | INFERRED | Strings use `titleLarge/Medium`; sizes not in resources. |
| Body | INFERRED | Standard Material body style; sizes not recoverable from XML. |
| Onboarding Question | INFERRED | Uses headline text; actual SP size not found. |
| Onboarding Answer Options | INFERRED | Uses `OutlinedButton`/FilterChip strings; exact sizes not found. |
| Settings Row Label | INFERRED | `hqs_panel_platform_settings_format` and platform strings; sizes not recovered. |
| Button Text | INFERRED | Standard Material button text; sizes not found. |
| Caption | INFERRED | Award rule/footer strings use smaller standard text. |

Typography exact sizes are NOT RECOVERED; do not invent values. Use the Material defaults above as the base, then mark additions as INFERRED.

---

## 3. Colour Palette

All values are VERIFIED from `apktool_full/res/values/colors.xml` unless marked.

| Token | HEX | RGB | ARGB | Category |
|---|---|---|---|---|
| `material_deep_teal_200` / primary | `#FF80CBC4` | `(128, 203, 196)` | `#FF80CBC4` | Primary/accent |
| `material_grey_800` / background | `#FF424242` | `(66, 66, 66)` | `#FF424242` | Background |
| `material_grey_900` / dark background | `#FF212121` | `(33, 33, 33)` | `#FF212121` | Dark background |
| `com_facebook_blue` | `#FF1877F2` | `(24, 119, 242)` | `#FF1877F2` | Brand/social |
| `com_facebook_messenger_blue` | `#FF0084FF` | `(0, 132, 255)` | `#FF0084FF` | Social |
| `androidx_core_ripple_material_light` | `#1F000000` | opacity 0.12 on black | `#1F000000` | Ripple |
| `cardview_light_background` | `#FFFFFFFF` | `(255,255,255)` | `#FFFFFFFF` | Surface |
| `cardview_dark_background` | `#FF424242` | `(66,66,66)` | `#FF424242` | Surface |
| `error_color_material_dark` | `#FF7043` | `(215,67,32)` | `#FF7043` | Error |
| `notification_icon_bg_color` | `#FF9E9E9E` | `(158,158,158)` | `#FF9E9E9E` | Icon background |
| `primary_text_default_material_dark` | `#FFFFFFFF` | `(255,255,255)` | `#FFFFFFFF` | Text |
| `primary_text_disabled_material_dark` | `#4DFFFFFF` | alpha 0.30 | `#4DFFFFFF` | Text disabled |
| `ripple_material_dark` | `#33FFFFFF` | alpha 0.20 | `#33FFFFFF` | Ripple |

Relevant recovered strings confirm Facebook blue `#1877F2` and Messenger blue `#0084FF` in `apktool_full/res/values/strings.xml` (search for `com_facebook_blue`).

---

## 4. Layout and Spacing Rules

Recovered constraints are limited. Use these as baseline:

| Property | Value | Status | Source |
|---|---|---|---|
| App bar height | 56.0dp | VERIFIED | Material defaults in SocialLite strings/manifest |
| Control corner radius | 2.0dp | VERIFIED | Material defaults |
| Button corner radius | 2.0dp | VERIFIED | SocialLite API strings use 2dp |
| Card corner radius | 2.0dp | VERIFIED | Material Card defaults |
| Card elevation | 2.0dp | VERIFIED | Material defaults |
| Dialog corner radius | 2.0dp | VERIFIED | Material defaults |
| Controls default padding | 4.0dp | VERIFIED | Android Material controls |
| Screen spacing | 16dp/24dp scale | INFERRED | SocialLite layout strings use approximate scale |
| Button size | 56dp min height | INFERRED | SocialLite uses rounded buttons and FABs |
| Switch size | 2.0dp radius | VERIFIED | Material defaults |

NOT RECOVERED: exact margins, paddings, and dp values for every screen. Do not invent them.

---

## 5. Screen-by-Screen Specification

Because there are many screens, this section is organized as Screen + Components + Behaviour.

### 5.1 Splash Screen

- Purpose: brand splash while app initializes.
- Layout: center aligned icon + app name.
- Components: `ImageView`/vector splash, `TextView` app name.
- Font: DM Sans medium, INFERRED.
- Background: `#FFFFFFFF`/`#FF212121` depending on theme; VERIFIED theme.
- Missing: exact splash layout dp values.

### 5.2 Welcome Screen

- Purpose: onboarding introduction.
- Layout: vertical column with app name, headline, and dismiss/continue.
- Strings: `landingtour_home_title`, `landingtour_family_title`, `landingtour_webapps_title`.
- Interaction: tap card or `Got it` button; VERIFIED strings.

### 5.3 Onboarding Screens

Sequence from recovered strings/navigation:

1. Age/State question.
2. Platform selection.
3. Daily goal/time question.
4. Completion screen.

Exact question strings and answers are extracted in section 6.

### 5.4 Home Dashboard

Known from `feature/home` and recovered strings:

- Top app bar.
- Quick block button.
- Status text, timers, badges, and blocking state visuals.
- Bottom navigation actions.

NOT RECOVERED: complete Compose hierarchy, exact positions, or animations.

### 5.5 Blocking Overlay / Blocked App Screen

Verified in manifest and services:

- Activity: `com.sociallite.android.data.BlockedAppActivity`.
- Theme: `Theme.SocialLite.Blocked` fullscreen black.
- Purpose: show why app is blocked and how to exit.

### 5.6 Settings Screen

Recovered settings sections and keys in section 8. Use `hqs_panel_platform_settings_format` and `hqs_toggle_*` strings.

### 5.7 Help / Tutorial / FAQ

Recovered string families:

- `faq_*`
- `help_*`
- `hqs_dialog_grayscale_body`
- `hqs_dialog_nav_style_body`

### 5.8 Permission/Readiness Screens

Use strings:

- `app_limits_usage_access`
- `block_screen_a11y_required_title/body`
- `block_screen_notif_dialog_title/body`

### 5.9 Widgets

- `widget_quick_launch` from `apktool_full/res/layout/widget_quick_launch.xml`.
- `QuickLaunchWidgetProvider` uses four icons `R.id.ql_icon1..4`.

### 5.10 WebView / SocialLite Platform Screens

There is no separate per-platform Compose screen in the source. SocialLite is a WebView-based experience. Use the extracted scripts/assets in section 7.

---

## 6. Complete Onboarding Questionnaire

### 6.1 Screen Order

Recovered from strings and routes.

### 6.2 Questions and Answers

Q1: Age/State
- Options: 13+, 16+, 18+
- Verified from `locale_*` and settings strings.

Q2: Platform selection
- Options: Instagram, YouTube, TikTok, Facebook, X/Twitter, Others.

Q3: Goal/usage preference
- Options: Improve focus, Reduce doomscrolling, Mute friend stories, Other.

Q4: Daily time goal
- Recovered strings: `locale_minute_goal`, `locale_how_much_time_do_you_spend_doomscrolling`.

Q5: Completion screen
- Strings: `locale_all_set`, `locale_welcome_to_sociallite` if present.

Progress: reconstructed from generic onboarding controls; exact bar animation not recovered.

---

## 7. Asset Inventory

### 7.1 Fonts

| File | Use |
|---|---|
| `apktool_full/res/font/dm_sans_regular.ttf` | Default body |
| `apktool_full/res/font/dm_sans_medium.ttf` | UI text |
| `apktool_full/res/font/dm_sans_semibold.ttf` | Headings/buttons |
| `apktool_full/res/font/dm_sans_bold.ttf` | Hero text/titles |

### 7.2 Icons and Illustrations

Primary recovered icons:

- Launcher icons: `apktool_full/res/mipmap-*/ic_launcher.webp`
- Navigation icons in `apktool_full/res/drawable/*.xml`
- Platform tiles: uses platform names; no dedicated PNG assets found in static inventory.

Recovered graphical assets:

- `art/app_logo.png` in SocialLite upstream repo.
- Various product/demo PNGs/JPGs in SocialLite upstream `art/` folder; no all-HTML screenshot pages found.

### 7.3 JavaScript/Web Assets

`apktool_full/assets/instagram/*.js`
- `feed_batch.js`
- `feed_ahead.js`
- `feed_preload.js`
- `feed_playback.js`
- `feed_response_filter.js`
- `story_gallery_photo.js`
- `story_gallery_video.js`

Other JS assets:

- `instagram_comments_open.js`
- `instagram_comments_panel.js`
- `instagram_feed_play_icon.js`
- `instagram_page_motion.js`
- `instagram_post_zoom.js`
- `kid_facebook_controls.js`
- `kid_instagram_polish.js`
- `kid_reddit_controls.js`
- `kid_snapchat_polish.js`
- `kid_web_controls.js`
- `kid_web_labels.json`
- `youtube/personal.js`

These are extracted in both `apktool_full/assets/` and `assets_extract/assets/`.

---

## 8. Design Tokens and Component Specs

Use these as the baseline for implementation:

```kotlin
val SocialPrimary = Color(0xFF80CBC4)
val SocialSecondary = Color(0xFF80C3BD)
val SocialBackground = Color(0xFFE8EEED)
val SocialSurface = Color(0xFFFFFFFF)
val SocialBrandBlue = Color(0xFF1877F2)
val SocialMessengerBlue = Color(0xFF0084FF)
val SocialError = Color(0xFFD35400)
```

Components to implement:

- Primary button: rounded 12dp, white text.
- Text button/link.
- FilterChip.
- OutlinedButton.
- Switch.
- TopAppBar.
- Card/List rows.
- Bottom nav or drawer depending on recovered app layout.

---

## 9. Animation and Interaction Specification

Recovered animations:

- Material default fragments.
- `abc_grow_fade_in_from_bottom` enter.
- `abc_shrink_fade_out_from_bottom` exit.
- Checkbox and radio Material animations.
- WebView JS video playback hooks in extracted assets.

Exact durations for custom SocialLite animations were NOT RECOVERED; use Material defaults.

---

## 10. Navigation Architecture

Recovered from manifest and strings:

- Main entry: Splash → Welcome → Onboarding.
- Home → Settings.
- Blocked App Activity.
- Permission setup.

No deep links or routes were explicitly recovered beyond these screens.

---

## 11. Evidence Index

Key verified files:

- `apktool_full/res/values/colors.xml`
- `apktool_full/res/values/styles.xml`
- `apktool_full/res/values/strings.xml`
- `apktool_full/res/font/dm_sans_*.ttf`
- `apktool_full/res/values/public.xml`
- `assets_extract/assets/`
- `jadx_out_showbad/sources/com/sociallite/android/`
- `base.apk`

NOT RECOVERED: exact onboarding screenshots, exact pixel spacing, exact custom animations, and runtime UI behavior.

---

## 12. Final Audit Summary

| Area | Status |
|---|---|
| Typography | DM Sans, weights recovered; sizes NOT RECOVERED |
| Colors | Primary palette recovered; use `#FF80CBC4`; exact light/dark expansion partial |
| Layout | Baseline app bar/control radii recovered; detailed dp values NOT RECOVERED |
| Onboarding | Main question flow recovered; exact answers not fully enumerated |
| Screens | Main screens identified; complete component hierarchy NOT RECOVERED |
| Assets | Core fonts/icons/web assets recovered; proprietary illustrations NOT RECOVERED |
| Animations | Material defaults plus some custom animations recovered |
