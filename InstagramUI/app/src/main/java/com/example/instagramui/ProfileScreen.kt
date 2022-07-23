package com.example.instagramui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBar(
            name = "Rahul_Roy_offcial",
            modifier = Modifier.padding(20.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()

    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp

        )

        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Back",
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(20.dp),
        )
    }
}

@Preview
@Composable
fun ProfileSection() {

    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.philipp), contentDescription = "Philip",
            modifier = Modifier
                .clip(CircleShape)
                .size(100.dp))
            Spacer(modifier = Modifier.width(16.dp))
            StatSection()
            Spacer(modifier = Modifier.width(5.dp))


        }
        ProfileDescription(
            displayName = "Programming Mentor",
            description = "10 years of coding experience\n" +
                    "Want me to make your app? Send me an email!\n" +
                    "Subscribe to my YouTube channel!",
            url = "https://youtube.com/c/PhilippLackner",
            followedBy = listOf("codinginflow", "miakhalifa"),
            otherCount = 17
        )
    }

}

@Composable
fun StatSection() {
    Row(

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ProfileStat(numberText = "601", text = "Posts")
        ProfileStat(numberText = "100K", text = "Followers")
        ProfileStat(numberText = "72", text = "Following")
    }
}

@Composable
fun ProfileStat(
    text: String,
    numberText : String
) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(
            top = 25.dp,
            start = 15.dp,
            end = 10.dp
        )
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, bottom = 15.dp)) {

            Text(text = displayName,
                 fontSize = 15.sp,
            fontWeight = FontWeight.Bold)

            Text(text = description,
                fontSize = 12.sp,
                )
            Text(text = url,
                color = Color(0xFF3D3D91),
                fontSize = 12.sp)

            if (followedBy.isNotEmpty()){
                Text(text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed By ")
                    followedBy.forEachIndexed { index, name ->

                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size -1){
                            append(" , ")
                        }
                    }
                    append(" and ")
                    pushStyle(boldStyle)
                    if (otherCount > 2){
                        append("$otherCount others")
                    }

                })
            }
            

            }
        }


@Preview
@Composable
fun Preview() {
    ProfileScreen()
}