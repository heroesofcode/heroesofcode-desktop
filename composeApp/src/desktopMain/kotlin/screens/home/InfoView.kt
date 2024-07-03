package screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.heroesofcode.desktop.design_system.AppColors
import com.seiko.imageloader.rememberImagePainter
import composeResources.Strings
import dto.InfoDTO

@Composable
fun InfoView(data: InfoDTO) {

    Image(
        painter = rememberImagePainter("${data.avatarUrl}"),
        contentDescription = null,
        modifier = Modifier.width(100.dp).height(100.dp),
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            "${data.name}",
            fontSize = 30.sp,
            color = AppColors.title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp)
        )

        Text(
            "${data.description}",
            fontSize = 16.sp,
            color = AppColors.subtitle,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(20.dp, 2.dp, 0.dp, 0.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth().padding(20.dp)
        ) {
            Text(
                "${Strings.FOLLOWERS} ${data.followers}",
                fontSize = 14.sp,
                color = AppColors.gray,
                fontWeight = FontWeight.Light,
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                "${Strings.FOLLOWING} ${data.following}",
                fontSize = 14.sp,
                color = AppColors.gray,
                fontWeight = FontWeight.Light,
            )
        }
    }
}