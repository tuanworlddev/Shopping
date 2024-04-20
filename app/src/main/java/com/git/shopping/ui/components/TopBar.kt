package com.git.shopping.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.git.shopping.R
import com.git.shopping.ui.theme.MainGray
import com.git.shopping.ui.theme.MainPurple
import com.git.shopping.ui.theme.circularFont

@Composable
fun TopBar() {

}

@Composable
fun Header () {
    Column() {
        Row {
            Spacer(modifier = Modifier.height(25.dp))
        }
        Row(modifier = Modifier.height(41.dp)) {
//            val borderstroke = BorderStroke(1.dp, colorResource(id = R.color.gray))
            Spacer(modifier = Modifier.width(20.dp))
            Image(painter = painterResource(id = R.drawable.teat3),
                contentDescription = null,
                modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier
                .weight(1f))
            Box(modifier = Modifier
                .width(80.dp)
                .fillMaxHeight()
                .clip(shape = RoundedCornerShape(50))
                .background(MainGray),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Men", fontFamily = circularFont, fontWeight = FontWeight(500))
                    Spacer(modifier = Modifier.width(5.dp))
                    Image(painter = painterResource(id = R.drawable.arrowdown2),
                        contentDescription = null, Modifier.size(16.dp))
                }

            }
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier
                .size(40.dp)
                .background(color = MainPurple, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(id = R.drawable.bag2), contentDescription = null,
                    modifier = Modifier.size(15.dp))
            }
            Spacer(modifier = Modifier.width(20.dp))

        }


    }

}