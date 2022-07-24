package com.example.instagramui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
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
        ButtonSection()
        Spacer(modifier = Modifier.height(20.dp))
        HighLightsSection(
            highlights = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.youtube),
                    text = "YouTube"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.qa),
                    text = "Q&A"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.discord),
                    text = "Discord"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.telegram),
                    text = "Telegram"
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

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

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 95.dp
    val height = 30.dp
    Row(modifier = modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceEvenly) {

        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .size(height)
        )
      
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(5.dp)
        ) {
            if (text != null){
                Text(text = text,
                fontWeight = FontWeight.Bold)
            }
        if (icon !=null){
            Icon(imageVector = icon, contentDescription = "Following", tint = Color.Black)
        }


    }
}

@Composable
fun HighLightsSection(
    modifier: Modifier = Modifier,
    highlights : List<ImageWithText>
) {
    LazyRow(modifier = modifier, horizontalArrangement = Arrangement.SpaceEvenly){
        items(highlights.size){
            Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(end = 5.dp)) {
                Image(painter = highlights[it].image, contentDescription = "Story",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(70.dp))

                Text(text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    modifier = modifier.padding(top = 5.dp)
                )
            }

        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    onTabSelected : (selectedIndex : Int) -> Unit
) {
    var selectedTabIndex by remember{
        mutableStateOf(0)
    }
    val inActiveColour = Color(0xF777777)
    TabRow(selectedTabIndex = selectedTabIndex, backgroundColor = Color.Transparent,
    contentColor = Color.Black,
    modifier = modifier) {
        Tab(selected = selectedTabIndex == 0, onClick = {
            selectedTabIndex = 0
            onTabSelected(0)

        }) {

        }
    }
}


@Preview
@Composable
fun Preview() {
    ProfileScreen()
}