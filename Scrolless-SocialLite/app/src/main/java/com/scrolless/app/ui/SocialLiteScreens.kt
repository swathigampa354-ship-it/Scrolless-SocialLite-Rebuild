/*
 * Copyright (C) 2026 SocialLite
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package com.scrolless.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.scrolless.app.designsystem.theme.socialPrimary
import com.scrolless.app.designsystem.theme.socialOnPrimary
import com.scrolless.app.designsystem.theme.socialSecondary
import com.scrolless.app.designsystem.theme.socialOnSurface
import com.scrolless.app.designsystem.theme.spacing

@Composable
fun SocialLiteHomeScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = { TopAppBar(title = { Text("SocialLite") }) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("Block Reels, Shorts & Spotlight", style = MaterialTheme.typography.headlineMedium)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FilterChip(selected = true, onClick = {}, label = { Text("Instagram") })
                FilterChip(selected = false, onClick = {}, label = { Text("YouTube") })
            }
            Button(onClick = {}, shape = RoundedCornerShape(12.dp), colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = socialPrimary, contentColor = socialOnPrimary)) {
                Text("Start Blocking")
            }
            TextButton(onClick = {}) { Text("Open Settings") }
        }
    }
}

@Composable
fun SocialLiteOnboardingScreen1(modifier: Modifier = Modifier) {
    Column(modifier.padding(spacing()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("How old are you?", style = MaterialTheme.typography.headlineLarge)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(onClick = {}) { Text("13+") }
            OutlinedButton(onClick = {}) { Text("16+") }
            OutlinedButton(onClick = {}) { Text("18+") }
        }
    }
}

@Composable
fun SocialLiteOnboardingScreen2(modifier: Modifier = Modifier) {
    Column(modifier.padding(spacing()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Choose your platform", style = MaterialTheme.typography.headlineLarge)
        Row {
            FilterChip(selected = true, onClick = {}, label = { Text("Instagram") })
            FilterChip(selected = true, onClick = {}, label = { Text("YouTube") })
            FilterChip(selected = false, onClick = {}, label = { Text("TikTok") })
        }
    }
}

@Composable
fun SocialLiteOnboardingScreen3(modifier: Modifier = Modifier) {
    Column(modifier.padding(spacing()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Set your daily limit", style = MaterialTheme.typography.headlineLarge)
        OutlinedTextField(value = "30", onValueChange = {}, label = { Text("Minutes per day") })
        Button(onClick = {}) { Text("Continue") }
    }
}

@Composable
fun SocialLiteSettingsScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = { TopAppBar(title = { Text("Settings") }) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Instagram Reels", style = MaterialTheme.typography.titleLarge, color = socialOnSurface)
                Spacer(Modifier.weight(1f))
                Switch(checked = true, onCheckedChange = {})
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("YouTube Shorts", style = MaterialTheme.typography.titleLarge, color = socialOnSurface)
                Spacer(Modifier.weight(1f))
                Switch(checked = true, onCheckedChange = {})
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Facebook Reels", style = MaterialTheme.typography.titleLarge, color = socialOnSurface)
                Spacer(Modifier.weight(1f))
                Switch(checked = false, onCheckedChange = {})
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Allow DMs", style = MaterialTheme.typography.titleLarge, color = socialOnSurface)
                Spacer(Modifier.weight(1f))
                Switch(checked = true, onCheckedChange = {})
            }
            Spacer(Modifier.height(8.dp))
            Text("Accent", style = MaterialTheme.typography.titleMedium, color = socialSecondary)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FilterChip(selected = true, onClick = {}, label = { Text("Socialte Blue") })
            }
        }
    }
}

@Composable
fun SocialLiteBlockingScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = { TopAppBar(title = { Text("Blocking") }) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("No short-form video feeds will open", style = MaterialTheme.typography.titleMedium)
            Text("Messages and ordinary posts remain usable.")
            Button(onClick = {}, shape = RoundedCornerShape(12.dp), colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = socialPrimary, contentColor = socialOnPrimary)) {
                Text("Start Blocking")
            }
        }
    }
}

@Composable
fun SocialLiteHelpScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = { TopAppBar(title = { Text("Help") }) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Tip: Enable accessibility to start blocking.")
            Text("Tip: Adjust daily limits in Settings.")
        }
    }
}
