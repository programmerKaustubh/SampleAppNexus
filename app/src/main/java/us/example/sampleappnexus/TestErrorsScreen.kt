package us.example.sampleappnexus

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Screen with buttons to trigger various errors and exceptions
 * for testing TestNexus Health Dashboard issue detection.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestErrorsScreen(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Test Errors") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Trigger Test Issues",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Use these buttons to trigger various errors that TestNexus can detect.",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ========== CRASH SECTION ==========
            SectionHeader("Crashes (CRITICAL)")

            ErrorButton(
                title = "Null Pointer Exception",
                description = "Trigger a NullPointerException crash",
                onClick = { triggerNullPointerException() },
                isDestructive = true
            )

            ErrorButton(
                title = "Array Index Out of Bounds",
                description = "Trigger an ArrayIndexOutOfBoundsException",
                onClick = { triggerArrayIndexOutOfBounds() },
                isDestructive = true
            )

            ErrorButton(
                title = "Illegal State Exception",
                description = "Trigger an IllegalStateException",
                onClick = { triggerIllegalStateException() },
                isDestructive = true
            )

            ErrorButton(
                title = "Number Format Exception",
                description = "Trigger a NumberFormatException",
                onClick = { triggerNumberFormatException() },
                isDestructive = true
            )

            ErrorButton(
                title = "Illegal Argument Exception",
                description = "Trigger an IllegalArgumentException",
                onClick = { triggerIllegalArgumentException() },
                isDestructive = true
            )

            ErrorButton(
                title = "Stack Overflow",
                description = "Trigger a StackOverflowError via infinite recursion",
                onClick = { triggerStackOverflow() },
                isDestructive = true
            )

            ErrorButton(
                title = "Concurrent Modification",
                description = "Trigger a ConcurrentModificationException",
                onClick = { triggerConcurrentModification() },
                isDestructive = true
            )

            ErrorButton(
                title = "Class Cast Exception",
                description = "Trigger a ClassCastException",
                onClick = { triggerClassCastException() },
                isDestructive = true
            )

            ErrorButton(
                title = "Unsupported Operation",
                description = "Trigger an UnsupportedOperationException",
                onClick = { triggerUnsupportedOperation() },
                isDestructive = true
            )

            ErrorButton(
                title = "Assertion Error",
                description = "Trigger an AssertionError",
                onClick = { triggerAssertionError() },
                isDestructive = true
            )

            ErrorButton(
                title = "Unique Timestamped Crash",
                description = "Guaranteed new crash signature every time",
                onClick = { triggerUniqueCrash() },
                isDestructive = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // ========== ANR SECTION ==========
            SectionHeader("ANR (CRITICAL)")

            ErrorButton(
                title = "Simulate ANR (5 seconds)",
                description = "Block main thread for 5 seconds",
                onClick = { triggerAnr() },
                isDestructive = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // ========== MEMORY SECTION ==========
            SectionHeader("Memory Issues (HIGH)")

            ErrorButton(
                title = "Out of Memory Error",
                description = "Trigger an OutOfMemoryError by allocating huge array",
                onClick = { triggerOutOfMemory() },
                isDestructive = true
            )

            ErrorButton(
                title = "GC Pressure",
                description = "Create rapid object allocations to stress GC",
                onClick = { triggerGcPressure() },
                isDestructive = false
            )

            Spacer(modifier = Modifier.height(16.dp))

            // ========== PERFORMANCE SECTION ==========
            SectionHeader("Performance Issues (MEDIUM)")

            ErrorButton(
                title = "Skip Frames (30+)",
                description = "Heavy computation on main thread",
                onClick = { triggerSkippedFrames(30) },
                isDestructive = false
            )

            ErrorButton(
                title = "Skip Frames (60+)",
                description = "Very heavy computation on main thread",
                onClick = { triggerSkippedFrames(60) },
                isDestructive = false
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
private fun SectionHeader(title: String) {
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp)
    )
}

@Composable
private fun ErrorButton(
    title: String,
    description: String,
    onClick: () -> Unit,
    isDestructive: Boolean
) {
    if (isDestructive) {
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error
            )
        ) {
            Column(modifier = Modifier.padding(vertical = 4.dp)) {
                Text(text = title, fontWeight = FontWeight.Medium)
                Text(
                    text = description,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onError.copy(alpha = 0.8f)
                )
            }
        }
    } else {
        OutlinedButton(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(vertical = 4.dp)) {
                Text(text = title, fontWeight = FontWeight.Medium)
                Text(
                    text = description,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
        }
    }
}

// ========== ERROR TRIGGER FUNCTIONS ==========

private fun triggerNullPointerException() {
    val nullString: String? = null
    @Suppress("UNNECESSARY_NOT_NULL_ASSERTION")
    println(nullString!!.length)
}

private fun triggerArrayIndexOutOfBounds() {
    val array = intArrayOf(1, 2, 3)
    @Suppress("UNUSED_VARIABLE")
    val value = array[10]
}

private fun triggerIllegalStateException() {
    throw IllegalStateException("This is a test IllegalStateException from SampleAppNexus")
}

private fun triggerNumberFormatException() {
    @Suppress("UNUSED_VARIABLE")
    val number = "not_a_number".toInt()
}

private fun triggerIllegalArgumentException() {
    throw IllegalArgumentException("This is a test IllegalArgumentException from SampleAppNexus")
}

private fun triggerStackOverflow() {
    fun recurse(depth: Int): Int = recurse(depth + 1)
    recurse(0)
}

private fun triggerConcurrentModification() {
    val list = mutableListOf("a", "b", "c", "d")
    for (item in list) {
        if (item == "b") list.remove(item)
    }
}

@Suppress("UNCHECKED_CAST")
private fun triggerClassCastException() {
    val obj: Any = "This is a String"
    val number = obj as Int
    println(number)
}

private fun triggerUnsupportedOperation() {
    val list = listOf("a", "b", "c")
    (list as MutableList<String>).add("d")
}

private fun triggerAssertionError() {
    assert(false) { "Test AssertionError from SampleAppNexus triggered at ${System.currentTimeMillis()}" }
}

private fun triggerUniqueCrash() {
    throw RuntimeException("Unique crash #${System.currentTimeMillis()} from SampleAppNexus")
}

private fun triggerAnr() {
    // Block main thread for 5+ seconds to trigger ANR
    Thread.sleep(5000)
}

private fun triggerOutOfMemory() {
    // Try to allocate a huge array that will cause OOM
    val hugeArrayList = ArrayList<ByteArray>()
    while (true) {
        // Allocate 50MB chunks until OOM
        hugeArrayList.add(ByteArray(50 * 1024 * 1024))
    }
}

private fun triggerGcPressure() {
    // Rapidly create and discard objects to stress GC
    val handler = Handler(Looper.getMainLooper())
    var count = 0
    val runnable = object : Runnable {
        override fun run() {
            // Create many temporary objects
            repeat(10000) {
                @Suppress("UNUSED_VARIABLE")
                val temp = ByteArray(1024) // 1KB each
            }
            count++
            if (count < 100) {
                handler.postDelayed(this, 10) // Run 100 times over 1 second
            }
        }
    }
    handler.post(runnable)
}

private fun triggerSkippedFrames(targetFrames: Int) {
    // Heavy computation on main thread to skip frames
    // Each frame is ~16ms, so we need to block for targetFrames * 16ms
    val blockTimeMs = targetFrames * 16L
    val endTime = System.currentTimeMillis() + blockTimeMs

    // Busy loop to consume CPU time
    @Suppress("ControlFlowWithEmptyBody")
    while (System.currentTimeMillis() < endTime) {
        // Busy wait - this will cause frame skips
        var sum = 0.0
        for (i in 0 until 10000) {
            sum += kotlin.math.sin(i.toDouble()) * kotlin.math.cos(i.toDouble())
        }
    }
}
