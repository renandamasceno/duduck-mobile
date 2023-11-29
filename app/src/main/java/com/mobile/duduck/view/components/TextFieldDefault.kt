package com.mobile.duduck.view.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.mobile.duduck.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldDefault(label: String? = null) {
    var textValue by remember {
        mutableStateOf("")
    }

    TextField(
        value = textValue,
        label = {
            if (label != null) {
                Text(
                    text = label,
                    color = colorResource(id = R.color.gray_textfields_duduck)
                )
            }
        },
        shape = MaterialTheme.shapes.large,
        singleLine = true,
        onValueChange = { newText ->
            textValue = newText
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                shape = MaterialTheme.shapes.large,
                color = colorResource(id = R.color.gray_textfields_duduck)
            )
    )
}