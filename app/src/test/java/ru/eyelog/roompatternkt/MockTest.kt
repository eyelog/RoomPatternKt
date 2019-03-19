package ru.eyelog.roompatternkt

import android.content.Context
import android.util.Log
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner
import ru.eyelog.roompatternkt.AppUtil.Companion.dataBase

private const val FAKE_STRING = "Some text"

@RunWith(MockitoJUnitRunner::class)
class MockTest {

    @Mock
    private lateinit var mockContext: Context

    @Test
    fun readStringFromContext_LocalizedString() {
        // Given a mocked Context injected into the object under test...
        `when`(mockContext.getString(R.string.app_name))
            .thenReturn(FAKE_STRING)
        val myObjectUnderTest = SomeFakeClass(mockContext)

        // ...when the string is returned from the object under test...
        val result: String = myObjectUnderTest.getSomeText()

        // ...then the result should be the expected one.
        assertThat(result, `is`(FAKE_STRING))
    }
}
