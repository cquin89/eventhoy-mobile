package com.losingtime.eventhoy.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
/*
@Composable
fun FilterBottomSheet(
    allDates: List<String>,
    allCategories: List<String>,
    onApplyFilters: (selectedDates: List<String>, selectedCategories: List<String>) -> Unit,
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    onDismiss: () -> Unit
) {
    var expandedDates by remember { mutableStateOf(true) }
    var expandedCategories by remember { mutableStateOf(true) }

    var selectedDates by remember { mutableStateOf(emptySet<String>()) }
    var selectedCategories by remember { mutableStateOf(emptySet<String>()) }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Filtros", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(16.dp))

            // Lista de fechas expandible
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expandedDates = !expandedDates }
                        .padding(vertical = 8.dp)
                ) {
                    Text("Fechas", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = if (expandedDates) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = null
                    )
                }

                if (expandedDates) {
                    LazyColumn {
                        items(allDates) { date ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        selectedDates = if (selectedDates.contains(date)) {
                                            selectedDates - date
                                        } else {
                                            selectedDates + date
                                        }
                                    }
                                    .padding(vertical = 4.dp)
                            ) {
                                Checkbox(
                                    checked = selectedDates.contains(date),
                                    onCheckedChange = null
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(date)
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Lista de categorías expandible
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expandedCategories = !expandedCategories }
                        .padding(vertical = 8.dp)
                ) {
                    Text("Categorías", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = if (expandedCategories) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = null
                    )
                }

                if (expandedCategories) {
                    LazyColumn {
                        items(allCategories) { category ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        selectedCategories = if (selectedCategories.contains(category)) {
                                            selectedCategories - category
                                        } else {
                                            selectedCategories + category
                                        }
                                    }
                                    .padding(vertical = 4.dp)
                            ) {
                                Checkbox(
                                    checked = selectedCategories.contains(category),
                                    onCheckedChange = null
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(category)
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { onApplyFilters(selectedDates.toList(), selectedCategories.toList()) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Aplicar filtros")
            }
        }
    }
}*/