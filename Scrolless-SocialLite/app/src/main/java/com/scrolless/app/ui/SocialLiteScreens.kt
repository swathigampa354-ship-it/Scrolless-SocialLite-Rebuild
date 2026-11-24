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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.scrolless.app.designsystem.theme.socialOnPrimary
import com.scrolless.app.designsystem.theme.socialOnSurface
import com.scrolless.app.designsystem.theme.socialPrimary
import com.scrolless.app.designsystem.theme.socialSecondary
import com.scrolless.app.designsystem.theme.socialSurface

@Composable
fun SocialLiteHomeScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = { TopAppBar(title = { Text("SocialLite") }) }) { padding ->
        Column(
            Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Block Reels, Shorts & Spotlight", style = MaterialTheme.typography.headlineMedium)
            Text("Block Reels & Shorts", style = MaterialTheme.typography.titleLarge, color = socialOnSurface)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FilterChip(selected = true, onClick = {}, label = { Text("Instagram") })
                FilterChip(selected = false, onClick = {}, label = { Text("YouTube") })
            }
            Button(
                onClick = {},
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = socialPrimary, contentColor = socialOnPrimary)
            ) { Text("Start Blocking") }
            TextButton(onClick = {}) { Text("Open Settings") }
        }
    }
}

@Composable
fun SocialLiteOnboardingScreen1(modifier: Modifier = Modifier) {
    Column(modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("How much time do you spend doomscrolling?", style = MaterialTheme.typography.headlineLarge)
        Text("%1$d min goal", style = MaterialTheme.typography.titleLarge, color = socialOnSurface)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(onClick = {}) { Text("13+") }
            OutlinedButton(onClick = {}) { Text("16+") }
            OutlinedButton(onClick = {}) { Text("18+") }
        }
    }
}

@Composable
fun SocialLiteOnboardingScreen2(modifier: Modifier = Modifier) {
    Column(modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Choose which platforms are enabled", style = MaterialTheme.typography.headlineLarge)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(selected = true, onClick = {}, label = { Text("Instagram") })
            FilterChip(selected = true, onClick = {}, label = { Text("YouTube") })
            FilterChip(selected = false, onClick = {}, label = { Text("TikTok") })
        }
    }
}

@Composable
fun SocialLiteOnboardingScreen3(modifier: Modifier = Modifier) {
    Column(modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Set your daily limit", style = MaterialTheme.typography.headlineLarge)
        Text("Minutes per day", color = socialOnSurface)
        OutlinedTextField(value = "30", onValueChange = {}, label = { Text("30 min goal") }, trailingIcon = { Text("min goal") })
        Button(onClick = {}) { Text("Continue") }
    }
}

@Composable
fun SocialLiteSettingsScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = { TopAppBar(title = { Text("App Settings") }) }) { padding ->
        Column(
            Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SettingsRow("Block Reels", true)
            SettingsRow("Block Shorts", true)
            SettingsRow("Block Facebook Reels", false)
            SettingsRow("Block DMs Only", true)
            Spacer(Modifier.height(8.dp))
            Text("%1$s settings", style = MaterialTheme.typography.titleMedium, color = socialSecondary)
        }
    }
}

@Composable
fun SocialLiteBlockingScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = { TopAppBar(title = { Text("Blocking") }) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("No short-form video feeds will open", style = MaterialTheme.typography.titleMedium)
            Text("Messages and ordinary posts remain usable.")
            Button(
                onClick = {},
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = socialPrimary, contentColor = socialOnPrimary)
            ) { Text("Start Blocking") }
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

@Composable
private fun SettingsRow(label: String, checked: Boolean, onToggle: () -> Unit = {}) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(label, style = MaterialTheme.typography.titleLarge, color = socialOnSurface)
        Spacer(Modifier.weight(1f))
        Switch(checked = checked, onCheckedChange = { onToggle() })
    }
}
