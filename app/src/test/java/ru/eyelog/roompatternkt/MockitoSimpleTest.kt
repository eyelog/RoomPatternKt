import android.util.Log
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MockitoSimpleTest {

    @Mock
    private lateinit var list: ArrayList<Int>

    @Before
    fun init(){
        list = ArrayList()
    }


    @Test
    fun shouldDoSomething() {
        list.add(100)
    }
}

