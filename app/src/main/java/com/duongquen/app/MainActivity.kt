package com.duongquen.app

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.AltRoute
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.LocalGasStation
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material.icons.filled.ReportProblem
import androidx.compose.material.icons.filled.Route
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material.icons.filled.Straighten
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.material.icons.filled.Traffic
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.TurnRight
import androidx.compose.material.icons.filled.TwoWheeler
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ---------- Design tokens (from Stitch "Đường Quen Navigation Design System") ----------

val Inter = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_extrabold, FontWeight.ExtraBold),
)

class DQ(val dark: Boolean) {
    val surface = if (dark) Color(0xFF0B1718) else Color(0xFFFAF8FF)
    val card = if (dark) Color(0xFF122123) else Color(0xFFFFFFFF)
    val container = if (dark) Color(0xFF16292B) else Color(0xFFEAEDFF)
    val containerHigh = if (dark) Color(0xFF1D3335) else Color(0xFFE2E7FF)
    val onSurface = if (dark) Color(0xFFE3EFEC) else Color(0xFF131B2E)
    val onVariant = if (dark) Color(0xFFA9BDB9) else Color(0xFF3E4947)
    val outline = if (dark) Color(0xFF2C4446) else Color(0xFFBDC9C6)
    val primary = if (dark) Color(0xFF1FC5A5) else Color(0xFF0F766E)
    val onPrimary = if (dark) Color(0xFF00201D) else Color.White
    val primaryDeep = if (dark) Color(0xFF5EE9CF) else Color(0xFF005C55)
    val primaryFixed = if (dark) Color(0xFF12403C) else Color(0xFF9CF2E8)
    val green = if (dark) Color(0xFF4ADE80) else Color(0xFF006E2D)
    val greenBar = if (dark) Color(0xFF22C55E) else Color(0xFF006E2D)
    val greenSoft = if (dark) Color(0xFF14462A) else Color(0xFF7CF994)
    val onGreenSoft = if (dark) Color(0xFF86EFAC) else Color(0xFF007230)
    val amber = if (dark) Color(0xFFFBBF24) else Color(0xFF734700)
    val amberBar = if (dark) Color(0xFFFBBF24) else Color(0xFFFFB95F)
    val amberDeep = Color(0xFF945D00)
    val amberFixed = if (dark) Color(0xFF3A2A0B) else Color(0xFFFFDDB8)
    val errorC = if (dark) Color(0xFF4A1D1A) else Color(0xFFFFDAD6)
    val onErrorC = if (dark) Color(0xFFFFB4AB) else Color(0xFF93000A)
    val red = Color(0xFFBA1A1A)
    val mapBg = if (dark) Color(0xFF0F1F21) else Color(0xFFEAEDFF)
    val street = if (dark) Color(0xFF2A3F42) else Color(0xFFCBD5E1)
}

@Composable
fun T(
    text: String,
    size: Int = 14,
    weight: FontWeight = FontWeight.Normal,
    color: Color,
    modifier: Modifier = Modifier,
    align: TextAlign? = null,
    lineHeight: Int = 0,
    maxLines: Int = Int.MAX_VALUE,
    spacing: Float = 0f,
) {
    Text(
        text, modifier = modifier, color = color, fontSize = size.sp, fontWeight = weight, fontFamily = Inter,
        textAlign = align, maxLines = maxLines, overflow = TextOverflow.Ellipsis, letterSpacing = spacing.sp,
        lineHeight = if (lineHeight > 0) lineHeight.sp else TextUnit.Unspecified,
    )
}

@Composable
fun TA(text: AnnotatedString, size: Int = 14, color: Color, modifier: Modifier = Modifier, lineHeight: Int = 20) {
    Text(text, modifier = modifier, color = color, fontSize = size.sp, fontFamily = Inter, lineHeight = lineHeight.sp)
}

@Composable
fun Ico(icon: ImageVector, tint: Color, size: Int = 20, modifier: Modifier = Modifier) {
    Icon(icon, null, tint = tint, modifier = modifier.size(size.dp))
}

// ---------- Activity / navigation ----------

enum class Screen { MyRoads, Compare, Nav, NavDetail }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { App() }
    }
}

@Composable
fun App() {
    var screen by rememberSaveable { mutableStateOf(Screen.MyRoads) }
    var dark by rememberSaveable { mutableStateOf(false) }
    val c = DQ(dark)
    BackHandler(enabled = screen != Screen.MyRoads) {
        screen = when (screen) {
            Screen.NavDetail -> Screen.Nav
            Screen.Nav -> Screen.Compare
            else -> Screen.MyRoads
        }
    }
    Box(Modifier.fillMaxSize().background(c.surface)) {
        when (screen) {
            Screen.MyRoads -> MyRoadsScreen(c, { dark = !dark }, { screen = Screen.Compare })
            Screen.Compare -> CompareScreen(c, { screen = Screen.MyRoads }, { screen = Screen.Nav })
            Screen.Nav -> NavScreen(c, { screen = Screen.Compare }, { screen = Screen.MyRoads }, { screen = Screen.NavDetail })
            Screen.NavDetail -> NavDetailScreen(c, { screen = Screen.MyRoads }, { screen = Screen.Nav })
        }
    }
}

// ---------- Shared pieces ----------

@Composable
fun Avatar(c: DQ, onClick: () -> Unit = {}) {
    Box(
        Modifier.size(32.dp).clip(CircleShape).background(c.primary).clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) { Ico(Icons.Filled.Person, c.onPrimary, 18) }
}

@Composable
fun CircleBtn(icon: ImageVector, tint: Color, bg: Color, size: Int = 44, onClick: () -> Unit = {}) {
    Box(
        Modifier.size(size.dp).shadow(4.dp, CircleShape).clip(CircleShape).background(bg).clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) { Ico(icon, tint, 22) }
}

@Composable
fun TopBar(
    c: DQ, title: String, subtitle: String? = null, small: String? = null,
    onBack: () -> Unit, trailing: @Composable () -> Unit,
) {
    Row(
        Modifier.fillMaxWidth().background(c.surface.copy(alpha = 0.94f)).statusBarsPadding().height(64.dp).padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Box(Modifier.size(48.dp).clip(CircleShape).clickable(onClick = onBack), contentAlignment = Alignment.Center) {
            Ico(Icons.AutoMirrored.Filled.ArrowBack, c.onSurface, 24)
        }
        Column(Modifier.weight(1f)) {
            if (small != null) T(small, 11, FontWeight.SemiBold, c.primary, spacing = 0.8f)
            T(title, 18, FontWeight.SemiBold, c.onSurface, maxLines = 1)
            if (subtitle != null) T(subtitle, 12, FontWeight.Medium, c.onVariant, maxLines = 1)
        }
        trailing()
    }
}

@Composable
fun Handle(c: DQ) {
    Box(Modifier.fillMaxWidth().padding(vertical = 4.dp), contentAlignment = Alignment.Center) {
        Box(Modifier.width(40.dp).height(6.dp).clip(RoundedCornerShape(50)).background(c.outline))
    }
}

@Composable
fun Sheet(c: DQ, modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier
            .fillMaxWidth()
            .shadow(10.dp, RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
            .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
            .background(c.surface)
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp),
        content = content,
    )
}

@Composable
fun Pill(bg: Color, modifier: Modifier = Modifier, h: Int = 6, v: Int = 3, content: @Composable () -> Unit) {
    Box(modifier.clip(RoundedCornerShape(50)).background(bg).padding(horizontal = h.dp, vertical = v.dp)) { content() }
}

/** Segmented bar: familiar vs unfamiliar. */
@Composable
fun FamiliarBar(familiar: Float, good: Color, warn: Color, track: Color, h: Int = 10) {
    Row(Modifier.fillMaxWidth().height(h.dp).clip(RoundedCornerShape(50)).background(track)) {
        Box(Modifier.weight(familiar.coerceAtLeast(0.001f)).fillMaxHeight().background(good))
        Box(Modifier.weight((1f - familiar).coerceAtLeast(0.001f)).fillMaxHeight().background(warn))
    }
}

@Composable
fun Dot(color: Color) = Box(Modifier.size(8.dp).clip(CircleShape).background(color))

private fun Color.over(bg: Color): Color {
    val a = alpha
    return Color(red * a + bg.red * (1 - a), green * a + bg.green * (1 - a), blue * a + bg.blue * (1 - a), 1f)
}

// ---------- Map canvas for the route-comparison screen (SVG from Stitch, redrawn) ----------

private class MapXf(val s: Float, val ox: Float, val oy: Float) {
    fun x(v: Float) = ox + v * s
    fun y(v: Float) = oy + v * s
    fun o(px: Float, py: Float) = Offset(x(px), y(py))
}

private fun DrawScope.line(m: MapXf, pts: List<Pair<Float, Float>>, color: Color, w: Float, dash: Boolean = false) {
    val p = Path()
    pts.forEachIndexed { i, (a, b) -> if (i == 0) p.moveTo(m.x(a), m.y(b)) else p.lineTo(m.x(a), m.y(b)) }
    drawPath(
        p, color,
        style = Stroke(
            width = w * m.s, cap = StrokeCap.Round, join = StrokeJoin.Round,
            pathEffect = if (dash) PathEffect.dashPathEffect(floatArrayOf(0.1f, 12f * m.s)) else null,
        ),
    )
}

private fun DrawScope.label(m: MapXf, t: String, x: Float, y: Float, size: Float, argb: Int, bold: Boolean = false, center: Boolean = false) {
    drawIntoCanvas {
        val p = Paint()
        p.isAntiAlias = true
        p.color = argb
        p.textSize = size * m.s
        p.isFakeBoldText = bold
        p.textAlign = if (center) Paint.Align.CENTER else Paint.Align.LEFT
        it.nativeCanvas.drawText(t, m.x(x), m.y(y), p)
    }
}

@Composable
fun CompareMap(c: DQ, selected: Int, modifier: Modifier) {
    Canvas(modifier.background(c.mapBg)) {
        val s = maxOf(size.width / 400f, size.height / 360f)
        val m = MapXf(s, (size.width - 400f * s) / 2f, (size.height - 360f * s) / 2f)
        fun park(a: Float, b: Float, c1x: Float, c1y: Float, ex: Float, ey: Float, c2x: Float, c2y: Float, ex2: Float, ey2: Float, alpha: Float) {
            val p = Path().apply {
                moveTo(m.x(a), m.y(b)); quadraticTo(m.x(c1x), m.y(c1y), m.x(ex), m.y(ey))
                quadraticTo(m.x(c2x), m.y(c2y), m.x(ex2), m.y(ey2)); close()
            }
            drawPath(p, (if (c.dark) Color(0xFF14532D) else Color(0xFFBBF7D0)).copy(alpha = alpha))
        }
        park(50f, 110f, 75f, 95f, 105f, 115f, 135f, 135f, 85f, 145f, 0.6f)
        park(130f, 55f, 165f, 45f, 185f, 70f, 205f, 95f, 150f, 95f, 0.5f)
        park(230f, 130f, 275f, 120f, 280f, 160f, 285f, 200f, 235f, 175f, 0.5f)
        val river = Path().apply {
            moveTo(m.x(210f), m.y(-10f))
            cubicTo(m.x(240f), m.y(40f), m.x(310f), m.y(80f), m.x(320f), m.y(150f))
            cubicTo(m.x(330f), m.y(220f), m.x(260f), m.y(250f), m.x(290f), m.y(320f))
            cubicTo(m.x(310f), m.y(360f), m.x(330f), m.y(370f), m.x(350f), m.y(380f))
        }
        drawPath(river, if (c.dark) Color(0xFF1E4E7A) else Color(0xFF7DB8FA), style = Stroke(width = 36f * s, cap = StrokeCap.Round))
        val st = c.street.copy(alpha = 0.75f)
        line(m, listOf(-10f to 130f, 260f to 130f), st, 4f)
        line(m, listOf(20f to 80f, 300f to 80f), st, 4f)
        line(m, listOf(10f to 210f, 380f to 210f), st, 4f)
        line(m, listOf(60f to -10f, 60f to 370f), st, 4f)
        line(m, listOf(165f to -10f, 165f to 370f), st, 4f)
        line(m, listOf(240f to 30f, 390f to 280f), st, 4f)
        val txt = if (c.dark) 0xFF9FB3B0.toInt() else 0xFF64748B.toInt()
        label(m, "Võ Thị Sáu", 70f, 75f, 7.5f, txt)
        label(m, "Điện Biên Phủ", 70f, 125f, 7.5f, txt)
        label(m, "Xô Viết Nghệ Tĩnh", 245f, 70f, 7.5f, txt)
        label(m, "Cầu Sài Gòn", 250f, 240f, 8f, txt, bold = true)
        drawCircle(Color.White, 10f * s, m.o(305f, 175f)); drawCircle(Color(0xFF0F766E), 3.5f * s, m.o(305f, 175f))
        label(m, "Landmark 81", 287f, 192f, 7.5f, 0xFF0F766E.toInt(), bold = true)
        drawCircle(Color.White, 9f * s, m.o(115f, 190f)); drawCircle(Color(0xFFCA8A04), 3.5f * s, m.o(115f, 190f))
        label(m, "Dinh Độc Lập", 91f, 206f, 7f, 0xFF854D0E.toInt(), bold = true)
        val grey = Color(0xFF94A3B8)
        line(m, listOf(65f to 95f, 165f to 95f, 245f to 130f, 310f to 210f, 340f to 250f), grey.copy(alpha = 0.6f), 5f)
        line(m, listOf(65f to 95f, 65f to 145f, 210f to 145f, 250f to 210f, 340f to 250f), grey.copy(alpha = 0.45f), 5f)
        val green = Color(0xFF16A34A); val amber = Color(0xFFF59E0B)
        val fam = listOf(65f to 95f, 125f to 95f, 175f to 130f, 255f to 130f, 285f to 180f)
        val unf = listOf(285f to 180f, 315f to 220f, 340f to 250f)
        val famDash = selected == 2
        val unfDash = selected != 3
        line(m, fam, if (famDash) amber else green, 8f, famDash)
        if (!famDash) line(m, fam, Color(0xFF4ADE80).copy(alpha = 0.8f), 3f)
        line(m, unf, if (unfDash) amber else green, 8f, unfDash)
        line(m, unf, if (unfDash) Color(0xFFFBBF24) else Color(0xFF4ADE80).copy(alpha = 0.8f), 3f)
        drawCircle(Color(0xFF0F766E), 14f * s, m.o(65f, 95f)); drawCircle(Color.White, 11f * s, m.o(65f, 95f))
        drawCircle(Color(0xFF0F766E), 4f * s, m.o(65f, 95f))
        drawRoundRect(Color(0xFF005C55), m.o(35f, 60f), Size(60f * s, 18f * s), CornerRadius(9f * s))
        label(m, "Nhà (Q.3)", 65f, 72f, 9f, 0xFFFFFFFF.toInt(), bold = true, center = true)
        drawCircle(Color(0xFF16A34A).copy(alpha = 0.25f), 16f * s, m.o(180f, 130f))
        drawCircle(Color.White, 10f * s, m.o(180f, 130f)); drawCircle(Color(0xFF16A34A), 7f * s, m.o(180f, 130f))
        drawCircle(Color(0xFFF59E0B), 15f * s, m.o(340f, 250f)); drawCircle(Color.White, 12f * s, m.o(340f, 250f))
        drawCircle(Color(0xFFD97706), 4.5f * s, m.o(340f, 250f))
        drawRoundRect(Color(0xFF131B2E), m.o(295f, 270f), Size(90f * s, 18f * s), CornerRadius(9f * s))
        label(m, "ĐH Bách Khoa / KHTN", 340f, 282f, 8f, 0xFFFFFFFF.toInt(), bold = true, center = true)
    }
}

// ---------- Screen: Compare routes ----------

private data class RouteOpt(val label: String, val icon: ImageVector, val hint: String, val where: String, val mins: Int, val km: String, val pct: Int)

@Composable
fun CompareScreen(c: DQ, onBack: () -> Unit, onStart: () -> Unit) {
    var sel by remember { mutableIntStateOf(1) }
    Box(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
            Spacer(Modifier.statusBarsPadding().height(64.dp))
            Box(Modifier.fillMaxWidth().height(360.dp)) {
                CompareMap(c, sel, Modifier.fillMaxSize())
                Row(
                    Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp).fillMaxWidth()
                        .shadow(8.dp, RoundedCornerShape(16.dp)).clip(RoundedCornerShape(16.dp))
                        .background(c.card.copy(alpha = 0.96f)).padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    Column(Modifier.height(52.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
                        Box(Modifier.size(16.dp).clip(CircleShape).background(c.primary), contentAlignment = Alignment.Center) {
                            Box(Modifier.size(6.dp).clip(CircleShape).background(c.card))
                        }
                        Box(Modifier.width(2.dp).weight(1f).padding(vertical = 2.dp).background(c.outline))
                        Ico(Icons.Filled.LocationOn, c.amber, 16)
                    }
                    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            T("Từ: Nhà (124 Võ Thị Sáu, Q.3)", 12, FontWeight.SemiBold, c.onSurface, Modifier.weight(1f), maxLines = 1)
                            Pill(c.greenSoft, h = 6, v = 2) { T("Điểm xuất phát", 10, FontWeight.Medium, c.onGreenSoft, maxLines = 1) }
                        }
                        Box(Modifier.fillMaxWidth().height(1.dp).background(c.containerHigh))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            T("Đến: Trường ĐH Quốc Gia", 14, FontWeight.Bold, c.onSurface, Modifier.weight(1f), maxLines = 1)
                            T("Cơ sở 1", 12, FontWeight.Medium, c.onVariant)
                        }
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Box(Modifier.size(32.dp).clip(CircleShape).background(c.container), contentAlignment = Alignment.Center) {
                            Ico(Icons.Filled.SwapVert, c.onSurface, 18)
                        }
                        Box(Modifier.size(28.dp).clip(CircleShape).background(c.primaryFixed), contentAlignment = Alignment.Center) {
                            Ico(Icons.Filled.TwoWheeler, if (c.dark) c.primaryDeep else Color(0xFF00504A), 16)
                        }
                    }
                }
                Column(
                    Modifier.align(Alignment.TopEnd).padding(end = 16.dp, top = 80.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    CircleBtn(Icons.Filled.Explore, c.primaryDeep, c.card)
                    CircleBtn(Icons.Filled.Layers, c.primaryDeep, c.card)
                    CircleBtn(Icons.Filled.Traffic, c.green, c.card)
                    CircleBtn(Icons.Filled.MyLocation, c.onPrimary, c.primary)
                }
            }
            Sheet(c, Modifier.offset(y = (-24).dp)) {
                Handle(c)
                Spacer(Modifier.height(6.dp))
                Row(Modifier.padding(horizontal = 4.dp), verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f)) {
                        T("Chọn lộ trình an tâm", 18, FontWeight.Bold, c.onSurface, lineHeight = 24)
                        T("Đo lường độ quen thuộc trước khi lăn bánh", 12, FontWeight.Medium, c.onVariant, lineHeight = 16)
                    }
                    Spacer(Modifier.width(8.dp))
                    Pill(c.greenSoft, h = 10, v = 5) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            Ico(Icons.Filled.Verified, c.onGreenSoft, 15)
                            T("Ưu tiên đường quen", 11, FontWeight.SemiBold, c.onGreenSoft, maxLines = 2, lineHeight = 13)
                        }
                    }
                }
                Spacer(Modifier.height(12.dp))
                val opts = listOf(
                    RouteOpt("Gợi ý cho bạn", Icons.Filled.Security, "Dễ đi nhất", "Qua Điện Biên Phủ", 24, "8.2", 80),
                    RouteOpt("Nhanh nhất", Icons.Filled.Bolt, "", "Qua hẻm XVNT", 22, "7.5", 30),
                    RouteOpt("Quen nhất", Icons.Filled.Shield, "Đã đi hơn 30 lần", "Đại lộ thẳng", 27, "9.1", 95),
                )
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    opts.forEachIndexed { i, o ->
                        val id = i + 1
                        val picked = sel == id
                        val shape = RoundedCornerShape(16.dp)
                        Column(
                            Modifier.fillMaxWidth()
                                .shadow(if (picked) 4.dp else 1.dp, shape)
                                .clip(shape)
                                .background(if (picked) c.primaryFixed.copy(alpha = 0.22f).over(c.card) else c.card)
                                .let { if (picked) it.border(BorderStroke(2.dp, c.primary), shape) else it }
                                .clickable { sel = id }
                                .padding(10.dp),
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Row(Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    val pbg = when (id) {
                                        1 -> c.primary
                                        2 -> c.errorC
                                        else -> if (c.dark) c.greenSoft else Color(0xFF7FFC97)
                                    }
                                    val pfg = when (id) {
                                        1 -> c.onPrimary
                                        2 -> c.onErrorC
                                        else -> if (c.dark) c.onGreenSoft else Color(0xFF002109)
                                    }
                                    Pill(pbg, h = 10, v = 3) {
                                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                            if (id != 1) Ico(o.icon, pfg, 13)
                                            T(o.label, 12, FontWeight.Bold, pfg)
                                        }
                                    }
                                    if (o.hint.isNotEmpty()) {
                                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                                            if (id == 1) Ico(Icons.Filled.Security, c.green, 14)
                                            T(o.hint, 12, FontWeight.SemiBold, c.green, maxLines = 1)
                                        }
                                    }
                                }
                                if (id == 1) Pill(c.container, h = 8, v = 2) { T(o.where, 11, FontWeight.Medium, c.onVariant, maxLines = 1) }
                                else T(o.where, 12, FontWeight.Medium, c.onVariant, maxLines = 1)
                            }
                            Spacer(Modifier.height(4.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Row(Modifier.weight(1f), verticalAlignment = Alignment.Bottom) {
                                    T("${o.mins}", 44, FontWeight.ExtraBold, c.onSurface, spacing = -1f, lineHeight = 48)
                                    Spacer(Modifier.width(6.dp))
                                    T("phút", 18, FontWeight.SemiBold, c.onVariant, Modifier.padding(bottom = 6.dp))
                                    Spacer(Modifier.width(8.dp))
                                    T("·", 18, FontWeight.Bold, c.outline, Modifier.padding(bottom = 6.dp))
                                    Spacer(Modifier.width(8.dp))
                                    T("${o.km} km", 18, FontWeight.Bold, c.onVariant, Modifier.padding(bottom = 6.dp))
                                }
                                val q = if (id == 2) "Chỉ ${o.pct}% quen" else if (id == 1) "${o.pct}% đường quen" else "${o.pct}% quen"
                                Pill(if (id == 2) c.amberFixed else c.greenSoft, h = 8, v = 2) {
                                    T(q, 12, FontWeight.Bold, if (id == 2) c.amber else if (id == 1) c.onGreenSoft else c.green)
                                }
                            }
                            Spacer(Modifier.height(8.dp))
                            FamiliarBar(o.pct / 100f, c.greenBar, c.amberDeep, c.container, if (picked) 10 else 8)
                            if (id == 1) {
                                Spacer(Modifier.height(4.dp))
                                Row {
                                    Row(Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                        Dot(c.greenBar); T("Đường quen: 6.6 km", 11, FontWeight.Medium, c.green)
                                    }
                                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                        Dot(c.amberDeep); T("Đoạn mới: 1.6 km", 11, FontWeight.Medium, c.amber)
                                    }
                                }
                            }
                            Spacer(Modifier.height(6.dp))
                            Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                when (id) {
                                    1 -> Ico(Icons.Filled.Favorite, c.primaryDeep, 17)
                                    2 -> Ico(Icons.Filled.Warning, c.amber, 16)
                                    else -> Ico(Icons.Filled.CheckCircle, c.green, 16)
                                }
                                when (id) {
                                    1 -> TA(
                                        buildAnnotatedString {
                                            append("Chậm hơn 2 phút nhưng ")
                                            withStyle(SpanStyle(fontWeight = FontWeight.SemiBold, color = c.onSurface)) { append("80% là đường bạn quen") }
                                            append(", mặt đường rộng ít ngã rẽ khó.")
                                        },
                                        14, c.onVariant,
                                    )
                                    2 -> T("Nhanh hơn 2 phút nhưng qua 4 ngã tư lạ và đoạn hẻm cua gấp.", 13, FontWeight.SemiBold, c.onVariant, lineHeight = 18)
                                    else -> T("Gần như 100% đường cũ thân thuộc, không sợ lạc hay chạy quá tốc độ.", 13, FontWeight.SemiBold, c.onVariant, lineHeight = 18)
                                }
                            }
                        }
                    }
                }
                Spacer(Modifier.height(16.dp))
                Row(Modifier.padding(horizontal = 4.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    PrefBtn(c, Icons.AutoMirrored.Filled.VolumeUp, "Giọng đọc miền Nam", Modifier.weight(1f))
                    PrefBtn(c, Icons.Filled.NotificationsActive, "Báo ngã rẽ trước 200m", Modifier.weight(1f))
                }
                Spacer(Modifier.height(16.dp))
                Row(
                    Modifier.fillMaxWidth().height(56.dp).shadow(8.dp, RoundedCornerShape(16.dp)).clip(RoundedCornerShape(16.dp))
                        .background(c.primary).clickable(onClick = onStart),
                    horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,
                ) {
                    Ico(Icons.Filled.Navigation, c.onPrimary, 24)
                    Spacer(Modifier.width(12.dp))
                    T("Bắt đầu đi (Lộ trình $sel)", 18, FontWeight.Bold, c.onPrimary)
                }
                Spacer(Modifier.height(8.dp))
                T(
                    "Ứng dụng sẽ cảnh báo âm thanh trước khi vào đoạn đường chưa quen", 12, FontWeight.Medium, c.onVariant,
                    Modifier.fillMaxWidth(), align = TextAlign.Center,
                )
                Spacer(Modifier.navigationBarsPadding())
            }
        }
        Box(Modifier.align(Alignment.TopCenter)) {
            TopBar(c, "So Sánh Tuyến Đường", "Đường quen • Điều hướng an toàn", onBack = onBack) {
                Box(Modifier.size(48.dp), contentAlignment = Alignment.Center) { Ico(Icons.Filled.Tune, c.onVariant, 22) }
                Avatar(c)
            }
        }
    }
}

@Composable
private fun PrefBtn(c: DQ, icon: ImageVector, label: String, modifier: Modifier) {
    Row(
        modifier.clip(RoundedCornerShape(12.dp)).background(c.container).padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,
    ) {
        Ico(icon, c.onVariant, 18)
        Spacer(Modifier.width(6.dp))
        T(label, 12, FontWeight.SemiBold, c.onVariant, lineHeight = 16)
    }
}

// ---------- Screen: My familiar roads (light + dark) ----------

private data class Road(
    val title: String, val times: String, val last: String, val chip: String, val side: String,
    val verified: Boolean, val icon: ImageVector, val on: Boolean,
)

@Composable
fun MyRoadsScreen(c: DQ, toggleDark: () -> Unit, onFindRoute: () -> Unit) {
    var filter by remember { mutableIntStateOf(0) }
    val roads = remember {
        mutableStateOf(
            listOf(
                Road("Đ. Võ Thị Sáu → Đ. Điện Biên Phủ", "Đã đi 42 lần", "Lần cuối: Hôm qua", "3.2 km • Đi làm & Đi học", "Bật ưu tiên dẫn đường", true, Icons.Filled.Verified, true),
                Road("Đ. Nam Kỳ Khởi Nghĩa (Q.3)", "Đã đi 35 lần", "2 ngày trước", "2.1 km • Đi làm", "Bật ưu tiên dẫn đường", true, Icons.Filled.Verified, true),
                Road("Hẻm 45 Hoàng Hoa Thám", "Đã đi 28 lần", "3 ngày trước", "1.4 km • Đường tắt quen thuộc", "Tránh kẹt xe giờ cao điểm", true, Icons.Filled.TurnRight, true),
                Road("Cầu Thủ Thiêm → Mai Chí Thọ", "Đã đi 16 lần", "Chủ nhật tuần trước", "4.8 km • Cuối tuần dạo mát", "Tần suất trung bình", false, Icons.Filled.Description, true),
            ),
        )
    }
    Box(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
            Spacer(Modifier.statusBarsPadding().height(64.dp))
            Row(Modifier.padding(horizontal = 16.dp, vertical = 8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Pill(c.greenSoft.copy(alpha = if (c.dark) 0.6f else 0.35f), h = 12, v = 7) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Ico(Icons.Filled.Lock, c.green, 16)
                        T("Lưu bảo mật trên thiết bị", 12, FontWeight.Medium, c.green, maxLines = 1)
                    }
                }
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Ico(Icons.Filled.CloudOff, c.onVariant, 16)
                    T("Không tải lên máy chủ", 12, FontWeight.Medium, c.onVariant, maxLines = 1)
                }
            }
            Row(
                Modifier.horizontalScroll(rememberScrollState()).padding(horizontal = 16.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                listOf("Tất cả" to Icons.Filled.CheckCircle, "Đi học" to Icons.Filled.School, "Đi làm" to Icons.Filled.Work).forEachIndexed { i, (l, ic) ->
                    val on = filter == i
                    Row(
                        Modifier.height(40.dp).clip(RoundedCornerShape(50))
                            .background(if (on) c.primary else c.card)
                            .let { if (!on) it.border(BorderStroke(1.dp, c.outline.copy(alpha = 0.5f)), RoundedCornerShape(50)) else it }
                            .clickable { filter = i }.padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp),
                    ) {
                        Ico(ic, if (on) c.onPrimary else c.onVariant, 18)
                        T(l, 14, FontWeight.SemiBold, if (on) c.onPrimary else c.onVariant)
                        if (i == 0) Pill(Color.White.copy(alpha = 0.2f), h = 8, v = 1) { T("18 đoạn", 11, FontWeight.Medium, if (on) c.onPrimary else c.onVariant) }
                    }
                }
            }
            Spacer(Modifier.height(4.dp))
            Image(
                painterResource(if (c.dark) R.drawable.map_roads_dark else R.drawable.map_roads_light), null,
                Modifier.fillMaxWidth().height(300.dp), contentScale = ContentScale.Crop, alignment = Alignment.TopCenter,
            )
            Sheet(c, Modifier.offset(y = (-24).dp)) {
                Handle(c)
                Spacer(Modifier.height(8.dp))
                Column(Modifier.fillMaxWidth().clip(RoundedCornerShape(24.dp)).background(c.container).padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Ico(Icons.Filled.Security, c.primaryDeep, 20)
                        Spacer(Modifier.width(8.dp))
                        T("THÁNG NÀY CỦA BẠN", 14, FontWeight.SemiBold, c.primaryDeep, Modifier.weight(1f), spacing = 1.2f)
                        Pill(c.greenSoft, h = 10, v = 4) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                Ico(Icons.Filled.TrendingUp, c.onGreenSoft, 15)
                                T("+18%", 12, FontWeight.Bold, c.onGreenSoft)
                            }
                        }
                    }
                    Spacer(Modifier.height(6.dp))
                    Row(verticalAlignment = Alignment.Bottom) {
                        T("128 km", 26, FontWeight.Bold, c.onSurface)
                        Spacer(Modifier.width(6.dp))
                        T("đường quen", 16, FontWeight.Normal, c.onVariant, Modifier.padding(bottom = 3.dp))
                    }
                    Spacer(Modifier.height(10.dp))
                    Row(
                        Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(c.card).padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        Box(Modifier.size(40.dp).clip(RoundedCornerShape(12.dp)).background(c.primaryFixed), contentAlignment = Alignment.Center) {
                            Ico(Icons.Filled.Route, if (c.dark) c.primaryDeep else Color(0xFF00504A), 22)
                        }
                        Column {
                            T("Tiết kiệm ~45 phút • Giảm 85% lạc đường", 13, FontWeight.SemiBold, c.onSurface, maxLines = 1)
                            T("Nhờ tối ưu các ngã ba quen và luồng giao thông", 11, FontWeight.Normal, c.onVariant, maxLines = 1)
                        }
                    }
                }
                Spacer(Modifier.height(16.dp))
                Row(Modifier.padding(horizontal = 4.dp), verticalAlignment = Alignment.CenterVertically) {
                    Ico(Icons.Filled.Route, c.primaryDeep, 22)
                    Spacer(Modifier.width(8.dp))
                    T("Cung đường quen thuộc nhất", 17, FontWeight.SemiBold, c.onSurface, Modifier.weight(1f))
                    T("Sắp xếp", 14, FontWeight.SemiBold, c.primaryDeep)
                }
                Spacer(Modifier.height(10.dp))
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    roads.value.forEachIndexed { idx, r ->
                        val shape = RoundedCornerShape(20.dp)
                        Column(Modifier.fillMaxWidth().shadow(1.dp, shape).clip(shape).background(c.card).padding(14.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    Modifier.size(40.dp).clip(CircleShape)
                                        .background(if (r.verified) (if (c.dark) c.greenSoft else Color(0xFF7FFC97)) else c.container),
                                    contentAlignment = Alignment.Center,
                                ) { Ico(r.icon, if (r.verified) (if (c.dark) c.onGreenSoft else Color(0xFF005320)) else c.onVariant, 22) }
                                Spacer(Modifier.width(12.dp))
                                Column(Modifier.weight(1f)) {
                                    T(r.title, 16, FontWeight.Bold, c.onSurface, maxLines = 1)
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        T(r.times, 13, FontWeight.Bold, if (r.verified) c.green else c.onVariant)
                                        T("  ·  ", 13, FontWeight.Normal, c.outline)
                                        T(r.last, 13, FontWeight.Normal, c.onVariant, maxLines = 1)
                                    }
                                }
                                Spacer(Modifier.width(8.dp))
                                Switch(
                                    checked = r.on,
                                    onCheckedChange = { v -> roads.value = roads.value.toMutableList().also { it[idx] = r.copy(on = v) } },
                                    colors = SwitchDefaults.colors(
                                        checkedTrackColor = c.primary, checkedThumbColor = Color.White,
                                        uncheckedTrackColor = c.container, uncheckedBorderColor = c.outline,
                                    ),
                                )
                            }
                            Spacer(Modifier.height(10.dp))
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Row(
                                    Modifier.weight(1f).clip(RoundedCornerShape(8.dp)).background(c.container).padding(horizontal = 10.dp, vertical = 7.dp),
                                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp),
                                ) {
                                    Ico(Icons.Filled.Straighten, c.onVariant, 16)
                                    T(r.chip, 12, FontWeight.Medium, c.onVariant, lineHeight = 16)
                                }
                                T(
                                    r.side, 12, FontWeight.SemiBold, if (r.verified) c.green else c.onVariant,
                                    Modifier.weight(0.8f), align = TextAlign.End, lineHeight = 16,
                                )
                            }
                        }
                    }
                }
                Spacer(Modifier.height(16.dp))
                Row(
                    Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(c.container).padding(14.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.Top,
                ) {
                    Ico(Icons.Filled.Info, c.primaryDeep, 20)
                    TA(
                        buildAnnotatedString {
                            append("Chỉ các cung đường đang bật ")
                            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) { append("\"Tính là đường quen\"") }
                            append(" mới được hệ thống ưu tiên dẫn dắt khi bạn tìm kiếm tuyến đường an tâm, giảm bớt đoạn rẽ lạ lẫm.")
                        },
                        13, c.onVariant, lineHeight = 20,
                    )
                }
                Spacer(Modifier.height(16.dp))
                Row(
                    Modifier.fillMaxWidth().height(56.dp).shadow(6.dp, RoundedCornerShape(50)).clip(RoundedCornerShape(50)).background(c.primary),
                    horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,
                ) {
                    Ico(Icons.Filled.AddCircleOutline, c.onPrimary, 24)
                    Spacer(Modifier.width(10.dp))
                    T("Thêm cung đường thủ công", 18, FontWeight.SemiBold, c.onPrimary)
                }
                Spacer(Modifier.height(10.dp))
                Row(
                    Modifier.fillMaxWidth().height(52.dp).clip(RoundedCornerShape(50)).background(c.container),
                    horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,
                ) {
                    Ico(Icons.Filled.History, c.primaryDeep, 22)
                    Spacer(Modifier.width(10.dp))
                    T("Xem toàn bộ lịch sử di chuyển", 16, FontWeight.SemiBold, c.primaryDeep)
                }
                Spacer(Modifier.navigationBarsPadding().height(8.dp))
            }
        }
        Box(Modifier.align(Alignment.TopCenter)) {
            TopBar(c, "Đường Quen Của Tôi", onBack = {}) {
                Box(Modifier.size(48.dp).clip(CircleShape).clickable(onClick = onFindRoute), contentAlignment = Alignment.Center) {
                    Ico(Icons.Filled.Tune, c.onVariant, 22)
                }
                Avatar(c, toggleDark)
            }
        }
    }
}

// ---------- Screen: Navigation (familiar section, minimal) ----------

@Composable
fun NavScreen(c: DQ, onBack: () -> Unit, onEnd: () -> Unit, onDetail: () -> Unit) {
    Box(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
            Spacer(Modifier.statusBarsPadding().height(64.dp))
            Column(
                Modifier.padding(horizontal = 16.dp, vertical = 8.dp).fillMaxWidth()
                    .shadow(8.dp, RoundedCornerShape(20.dp)).clip(RoundedCornerShape(20.dp)).background(Color(0xFF0F766E))
                    .clickable(onClick = onDetail),
            ) {
                Row(Modifier.padding(horizontal = 14.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(Modifier.size(58.dp).clip(RoundedCornerShape(14.dp)).background(Color(0xFF005C55)), contentAlignment = Alignment.Center) {
                        Ico(Icons.Filled.TurnRight, Color.White, 40)
                    }
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.Bottom) {
                            T("350", 44, FontWeight.Bold, Color.White, spacing = -1f, lineHeight = 48)
                            T(" m", 20, FontWeight.SemiBold, Color(0xFFA3FAEF), Modifier.padding(bottom = 6.dp))
                        }
                        T("Rẽ phải vào Phố Triều Khúc", 16, FontWeight.SemiBold, Color.White, maxLines = 1)
                    }
                    Column(
                        Modifier.clip(RoundedCornerShape(12.dp)).background(Color(0xFF005C55)).padding(horizontal = 10.dp, vertical = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        T("38", 26, FontWeight.Bold, Color.White, lineHeight = 28)
                        T("KM/H", 11, FontWeight.Medium, Color(0xFFA3FAEF))
                    }
                    Spacer(Modifier.width(8.dp))
                    Box(
                        Modifier.size(54.dp).clip(CircleShape).background(Color.White).border(BorderStroke(4.dp, Color(0xFFD32F2F)), CircleShape),
                        contentAlignment = Alignment.Center,
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            T("40", 20, FontWeight.ExtraBold, Color(0xFFD32F2F), lineHeight = 22)
                            T("TỐI ĐA", 7, FontWeight.Bold, Color(0xFF131B2E))
                        }
                    }
                }
                Row(
                    Modifier.fillMaxWidth().background(Color(0xFF005C55)).padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Ico(Icons.Filled.TwoWheeler, Color(0xFFA3FAEF), 22)
                    Spacer(Modifier.width(10.dp))
                    T("Làn xe máy: Đi 2 làn sát lề phải", 14, FontWeight.Medium, Color.White, Modifier.weight(1f), lineHeight = 19)
                    Spacer(Modifier.width(8.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        listOf(false, false, true, true).forEach { on ->
                            Box(
                                Modifier.size(28.dp).clip(RoundedCornerShape(6.dp)).background(if (on) Color(0xFF7FFC97) else Color(0xFF0F766E)),
                                contentAlignment = Alignment.Center,
                            ) { Ico(Icons.Filled.TurnRight, if (on) Color(0xFF002109) else Color(0xFF3E8A83), 18) }
                        }
                    }
                }
            }
            Image(
                painterResource(R.drawable.map_nav), null,
                Modifier.fillMaxWidth().height(380.dp), contentScale = ContentScale.Crop,
            )
            Sheet(c, Modifier.offset(y = (-24).dp)) {
                Handle(c)
                Spacer(Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.Bottom) {
                            T("18", 44, FontWeight.ExtraBold, c.green, lineHeight = 48)
                            T(" phút", 22, FontWeight.SemiBold, c.green, Modifier.padding(bottom = 6.dp))
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            T("17:42 tới nơi", 16, FontWeight.Normal, c.onVariant)
                            T("  •  ", 16, FontWeight.Normal, c.outline)
                            T("6.4 km", 16, FontWeight.Bold, c.onVariant)
                        }
                    }
                    EndButton(c.errorC, c.onErrorC, onEnd)
                }
                Spacer(Modifier.height(14.dp))
                Column(Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(c.container).padding(14.dp)) {
                    Row {
                        Row(Modifier.weight(1f), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Box(Modifier.padding(top = 6.dp)) { Dot(c.greenBar) }
                            T("Đường quen 70% (4.5 km)", 14, FontWeight.SemiBold, c.green, lineHeight = 20)
                        }
                        Row(Modifier.weight(1f), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Box(Modifier.padding(top = 6.dp)) { Dot(c.amberBar) }
                            T("Đoạn mới 30% (1.9 km)", 14, FontWeight.SemiBold, c.amber, lineHeight = 20)
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                    FamiliarBar(0.7f, c.greenBar, c.amberBar, c.containerHigh, 12)
                }
                Spacer(Modifier.height(12.dp))
                InfoCard(
                    c, Icons.Filled.Info, if (c.dark) c.amberFixed else Color(0xFF945D00), if (c.dark) c.amber else Color.White,
                    "SẮP VÀO ĐOẠN LẠ", "Phố Triều Khúc", c.amber,
                    "Ngõ nhỏ hẹp, có chợ cóc họp giờ tan tầm. Chú ý xe ôm công nghệ quay đầu và không rẽ vào ngõ cấm giờ cao điểm.",
                    onDetail,
                )
                Spacer(Modifier.height(12.dp))
                InfoCard(
                    c, Icons.Filled.Verified, if (c.dark) c.greenSoft else Color(0xFF7FFC97), if (c.dark) c.onGreenSoft else Color(0xFF005320),
                    "ĐOẠN QUEN THUỘC", "Đã đi 24 lần", c.green,
                    "Đoạn Nguyễn Trãi – Quang Trung đang lưu thông thông thoáng. Giữ tốc độ ổn định 35–40 km/h.",
                    {},
                )
                Spacer(Modifier.height(16.dp))
                T("TIỆN ÍCH NHANH TRÊN ĐƯỜNG", 14, FontWeight.SemiBold, c.onVariant, spacing = 0.4f)
                Spacer(Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    QuickChip(c, Icons.Filled.LocalGasStation, "Tìm cây xăng", Modifier.weight(1f))
                    QuickChip(c, Icons.Filled.WaterDrop, "Tránh đoạn ngập", Modifier.weight(1f))
                    QuickChip(c, Icons.Filled.Share, "Chia sẻ lộ trình", Modifier.weight(1f))
                }
                Spacer(Modifier.navigationBarsPadding().height(8.dp))
            }
        }
        Box(Modifier.align(Alignment.TopCenter)) {
            TopBar(c, "Điều Hướng Trực Tiếp", onBack = onBack) { Avatar(c, onEnd) }
        }
    }
}

@Composable
private fun EndButton(bg: Color, fg: Color, onClick: () -> Unit) {
    Row(
        Modifier.shadow(3.dp, RoundedCornerShape(50)).clip(RoundedCornerShape(50)).background(bg).clickable(onClick = onClick)
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Ico(Icons.Filled.Close, fg, 24)
        T("Kết thúc", 18, FontWeight.Bold, fg)
    }
}

@Composable
private fun InfoCard(
    c: DQ, icon: ImageVector, iconBg: Color, iconFg: Color, head: String, sub: String, headColor: Color, body: String, onClick: () -> Unit,
) {
    Row(
        Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(c.container).clickable(onClick = onClick).padding(14.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.Top,
    ) {
        Box(Modifier.size(44.dp).clip(CircleShape).background(iconBg), contentAlignment = Alignment.Center) { Ico(icon, iconFg, 24) }
        Column(Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                T(head, 14, FontWeight.Bold, headColor, spacing = 0.6f)
                T("  •  $sub", 13, FontWeight.Normal, c.onVariant, maxLines = 1)
            }
            Spacer(Modifier.height(4.dp))
            T(body, 15, FontWeight.Normal, c.onSurface, lineHeight = 22)
        }
    }
}

@Composable
private fun QuickChip(c: DQ, icon: ImageVector, label: String, modifier: Modifier) {
    Column(
        modifier.clip(RoundedCornerShape(14.dp)).background(c.container).padding(vertical = 12.dp, horizontal = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Ico(icon, c.primaryDeep, 22)
        T(label, 13, FontWeight.SemiBold, c.onSurface, align = TextAlign.Center, maxLines = 1)
    }
}

// ---------- Screen: Turn-by-turn, unfamiliar section (detailed) ----------

@Composable
fun NavDetailScreen(c: DQ, onEnd: () -> Unit, onQuiet: () -> Unit) {
    Box(Modifier.fillMaxSize()) {
        Canvas(Modifier.fillMaxSize().background(c.mapBg)) {
            val w = size.width; val h = size.height
            val block = if (c.dark) Color(0xFF14292B) else Color.White
            listOf(0.05f to 0.35f, 0.5f to 0.47f, 0.62f to 0.18f, 0.12f to 0.56f).forEach { (x, y) ->
                drawRoundRect(block, Offset(w * x, h * y), Size(w * 0.3f, h * 0.17f), CornerRadius(14f))
            }
            listOf(0.33f, 0.5f, 0.62f, 0.74f).forEach { y -> drawLine(c.street, Offset(0f, h * y), Offset(w, h * (y + 0.01f)), 5f) }
            listOf(0.18f, 0.7f).forEach { x -> drawLine(c.street, Offset(w * x, 0f), Offset(w * (x + 0.02f), h), 5f) }
            drawLine(Color.White.copy(alpha = if (c.dark) 0.1f else 0.9f), Offset(0f, h * 0.45f), Offset(w, h * 0.45f), 26f)
            val p = Path().apply {
                moveTo(w * 0.47f, h * 0.30f); lineTo(w * 0.49f, h * 0.55f); lineTo(w * 0.5f, h * 0.7f); lineTo(w * 0.5f, h * 0.9f)
            }
            drawPath(p, Color(0xFF16A34A), style = Stroke(width = 22f, cap = StrokeCap.Round, join = StrokeJoin.Round))
            drawPath(p, Color(0xFF86EFAC), style = Stroke(width = 7f, cap = StrokeCap.Round, join = StrokeJoin.Round))
            val pos = Offset(w * 0.49f, h * 0.575f)
            drawCircle(Color(0xFF0288D1).copy(alpha = 0.18f), 56f, pos)
            drawCircle(Color.White, 24f, pos); drawCircle(Color(0xFF0288D1), 16f, pos)
            drawIntoCanvas {
                val pt = Paint()
                pt.isAntiAlias = true
                pt.color = if (c.dark) 0xFF9FB3B0.toInt() else 0xFF64748B.toInt()
                pt.textSize = 30f
                pt.isFakeBoldText = true
                it.nativeCanvas.drawText("HOÀNG HOA THÁM", w * 0.09f, h * 0.465f, pt)
                it.nativeCanvas.save()
                it.nativeCanvas.rotate(-90f, w * 0.43f, h * 0.55f)
                it.nativeCanvas.drawText("Đ. NGUYỄN TRÃI", w * 0.43f - 40f, h * 0.55f, pt)
                it.nativeCanvas.restore()
            }
        }
        Column(Modifier.fillMaxSize()) {
            TopBar(c, "Điều Hướng Trực Tiếp", small = "ĐƯỜNG QUEN • ĐANG LÁI", onBack = onQuiet) {
                Ico(Icons.AutoMirrored.Filled.VolumeUp, c.onVariant, 24)
                Ico(Icons.Filled.ReportProblem, c.onVariant, 24)
                Avatar(c, onEnd)
            }
            Box(Modifier.weight(1f).fillMaxWidth()) {
                Column(Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                    Row(
                        Modifier.shadow(3.dp, RoundedCornerShape(50)).clip(RoundedCornerShape(50)).background(c.card).padding(4.dp),
                        horizontalArrangement = Arrangement.spacedBy(2.dp),
                    ) {
                        Row(
                            Modifier.clip(RoundedCornerShape(50)).clickable(onClick = onQuiet).padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp),
                        ) {
                            Ico(Icons.Filled.Verified, c.onVariant, 18)
                            T("Đoạn Quen (Tối giản)", 13, FontWeight.Medium, c.onVariant, maxLines = 1)
                        }
                        Row(
                            Modifier.clip(RoundedCornerShape(50)).background(if (c.dark) c.primary else Color(0xFF005C55)).padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp),
                        ) {
                            Ico(Icons.Filled.Warning, Color.White, 18)
                            T("Đoạn Lạ (Chi tiết)", 13, FontWeight.SemiBold, Color.White, maxLines = 1)
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Column(
                        Modifier.fillMaxWidth(0.82f).shadow(8.dp, RoundedCornerShape(20.dp)).clip(RoundedCornerShape(20.dp)).background(c.card).padding(12.dp),
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Pill(c.amberFixed, h = 10, v = 4) {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                    Ico(Icons.Filled.Warning, c.amber, 14)
                                    T("Đoạn mới lạ · Giảm tốc độ", 11, FontWeight.Medium, c.amber, maxLines = 1)
                                }
                            }
                            Spacer(Modifier.width(6.dp))
                            T("Chú ý biển báo", 11, FontWeight.SemiBold, c.amber, maxLines = 1)
                        }
                        Spacer(Modifier.height(10.dp))
                        Row(verticalAlignment = Alignment.Top) {
                            Box(Modifier.size(56.dp).clip(RoundedCornerShape(16.dp)).background(Color(0xFFFFB95F)), contentAlignment = Alignment.Center) {
                                Ico(Icons.Filled.TurnRight, Color(0xFF2A1700), 36)
                            }
                            Spacer(Modifier.width(10.dp))
                            Column {
                                Row(verticalAlignment = Alignment.Bottom) {
                                    T("Sau 120 m", 30, FontWeight.Bold, c.onSurface, lineHeight = 34)
                                    T("  HẺM 45", 13, FontWeight.Bold, c.amber, Modifier.padding(bottom = 4.dp))
                                }
                                Spacer(Modifier.height(4.dp))
                                Row(
                                    Modifier.clip(RoundedCornerShape(12.dp)).background(c.container).padding(8.dp),
                                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp),
                                ) {
                                    Box(Modifier.size(28.dp).clip(RoundedCornerShape(8.dp)).background(c.primary), contentAlignment = Alignment.Center) {
                                        Ico(Icons.Filled.Storefront, c.onPrimary, 16)
                                    }
                                    TA(
                                        buildAnnotatedString {
                                            append("Đến ngã tư có ")
                                            withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = c.primaryDeep)) { append("tiệm tạp hóa màu xanh") }
                                            append(", rẽ phải vào hẻm.")
                                        },
                                        14, c.onSurface, Modifier.weight(1f, fill = false), lineHeight = 19,
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            T("Làn khuyên dùng:", 12, FontWeight.Normal, c.onVariant, Modifier.width(76.dp), lineHeight = 18)
                            Row(
                                Modifier.weight(1f).clip(RoundedCornerShape(8.dp)).background(c.containerHigh).padding(horizontal = 8.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp),
                            ) {
                                Ico(Icons.Filled.TwoWheeler, c.onVariant, 18)
                                T("Làn xe máy trong cùng bên phải", 12, FontWeight.Normal, c.onSurface, lineHeight = 16)
                            }
                        }
                    }
                }
                Column(
                    Modifier.align(Alignment.TopEnd).padding(top = 8.dp, end = 12.dp).width(64.dp)
                        .shadow(6.dp, RoundedCornerShape(16.dp)).clip(RoundedCornerShape(16.dp)).background(c.card).padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    T("34", 30, FontWeight.Bold, c.primaryDeep, lineHeight = 32)
                    T("KM/H", 11, FontWeight.Medium, c.onVariant)
                    Spacer(Modifier.height(6.dp))
                    Box(Modifier.size(36.dp).clip(CircleShape).background(c.errorC), contentAlignment = Alignment.Center) {
                        T("40", 14, FontWeight.Bold, c.onErrorC)
                    }
                }
                Column(
                    Modifier.align(Alignment.CenterEnd).padding(end = 12.dp, top = 120.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    CircleBtn(Icons.Filled.Navigation, c.red, c.card, 48)
                    CircleBtn(Icons.Filled.RecordVoiceOver, c.primaryDeep, c.card, 48)
                    CircleBtn(Icons.Filled.MyLocation, c.onPrimary, c.primary, 48)
                }
                Row(
                    Modifier.align(Alignment.BottomStart).padding(start = 16.dp, bottom = 40.dp)
                        .shadow(4.dp, RoundedCornerShape(50)).clip(RoundedCornerShape(50)).background(c.card).padding(horizontal = 14.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Dot(c.greenBar)
                    TA(
                        buildAnnotatedString {
                            append("Đang trên: ")
                            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) { append("Đ. Phan Đăng Lưu") }
                        },
                        13, c.onSurface,
                    )
                }
            }
            Sheet(c) {
                Handle(c)
                Spacer(Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.Bottom) {
                            T("12", 44, FontWeight.ExtraBold, c.primaryDeep, lineHeight = 48)
                            T(" phút", 20, FontWeight.SemiBold, c.primaryDeep, Modifier.padding(bottom = 6.dp))
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            T("4.1 km", 16, FontWeight.Normal, c.onVariant)
                            T("  •  ", 16, FontWeight.Normal, c.outline)
                            T("Đến lúc ", 16, FontWeight.Normal, c.onVariant)
                            T("20:45", 16, FontWeight.Bold, c.onSurface)
                        }
                    }
                    EndButton(c.red, Color.White, onEnd)
                }
                Spacer(Modifier.height(10.dp))
                Row {
                    Row(Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Dot(c.greenBar); T("3.3 km Quen thuộc", 13, FontWeight.SemiBold, c.green, maxLines = 1)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Dot(c.amberBar); T("0.8 km Đoạn lạ (Cần quan sát)", 13, FontWeight.SemiBold, c.amber, maxLines = 1)
                    }
                }
                Spacer(Modifier.height(6.dp))
                FamiliarBar(3.3f / 4.1f, c.greenBar, c.amberBar, c.container, 8)
                Spacer(Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    DetailChip(c, Icons.Filled.LocalGasStation, "Trạm xăng", Modifier.weight(1f))
                    DetailChip(c, Icons.Filled.Traffic, "Báo kẹt/...", Modifier.weight(1f))
                    DetailChip(c, Icons.AutoMirrored.Filled.AltRoute, "Đổi tuyến", Modifier.weight(1f))
                }
                Spacer(Modifier.navigationBarsPadding())
            }
        }
    }
}

@Composable
private fun DetailChip(c: DQ, icon: ImageVector, label: String, modifier: Modifier) {
    Row(
        modifier.height(44.dp).clip(RoundedCornerShape(14.dp)).background(c.container).padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
    ) {
        Ico(icon, c.primaryDeep, 20)
        Spacer(Modifier.width(6.dp))
        T(label, 14, FontWeight.SemiBold, c.onSurface, maxLines = 1)
    }
}
