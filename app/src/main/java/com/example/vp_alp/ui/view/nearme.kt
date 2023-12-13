package com.example.vp_alp.ui.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vp_alp.R
import com.example.vp_alp.data.loadNear
import com.example.vp_alp.model.near

@Composable
fun nearme(nearcardlist:List<near>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "image description",
                contentScale = ContentScale.None,
                modifier = Modifier.padding(end=16.dp)
            )
            Text(
                text = "Near Me",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 21.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),

                    )
            )

        }
        val context = LocalContext.current
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
        ) {
            items(nearcardlist){
                nearCard(
                    it,
                    Modifier
                        .padding(4.dp)

                )
            }
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }


        }





    }
}



@Composable
fun nearCard(near: near, modifier: Modifier = Modifier) {
    val    context = LocalContext.current
    Column(modifier = Modifier
        .padding(vertical = 8.dp)
        .clickable {
            Toast.makeText(context, "Do something ", Toast.LENGTH_SHORT).show()
        })
    {
        Row(
            modifier=Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .width(119.dp)
                    .height(119.dp)
                    .clip(RoundedCornerShape(size = 10.dp))
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x66000000),
                        ambientColor = Color(0x66000000)
                    )
                    .border(
                        width = 1.dp,
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(size = 10.dp)
                    ))
            {
                Image(
                    painter = painterResource(id = near.image_path),
                    contentDescription = "Image description",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(size = 10.dp))
                )
            }

            Column(modifier= Modifier
                .padding(10.dp)) {
                Text(
                    text = near.name,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),

                        )
                )
                Row(modifier=Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(id = R.drawable.baseline_star_rate_24), contentDescription = "")
                    Text(
                        text = near.rating.toString(),
                        style = TextStyle(
                            fontSize = 11.sp,
                            lineHeight = 21.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),

                            )
                    )
                }

                Text(
                    text = near.phone,
                    style = TextStyle(
                        fontSize = 11.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),

                        ),
                    modifier=Modifier.padding(bottom = 2.dp)
                )
                Text(
                    text = near.address,
                    style = TextStyle(
                        fontSize = 11.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),

                        ),
                            maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(

                        modifier = Modifier.weight(1f)
                            .clickable {
                                Toast.makeText(context, "Do something bro", Toast.LENGTH_SHORT).show()
                            },
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_favorite_24),
                            contentDescription = "",
                            modifier = Modifier.padding(end = 8.dp, bottom = 8.dp)
                        )
                    }
                }
            }





        }

    }
}










@Preview(showBackground = true, showSystemUi = true)
@Composable
fun nearmePreview(){
    nearme(loadNear())

}