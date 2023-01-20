package com.example.exercice3kotlin


import com.google.common.truth.Truth.assertThat
import org.junit.Test


class TestRegistrationTest{
    @Test
    fun `empty user name return false ` (){
        val result = testRegistration.validation(
            "",
            "123",
            "1246"
        )
        assertThat(result).isTrue(

        );

    }
    @Test
    fun `password is not equal to the other  ` (){
        val result = testRegistration.validation(
            "hanan",
            "123",
            "1246"
        )
        assertThat(result).isTrue();

    }
    @Test
    fun `password is empty ` (){
        val result = testRegistration.validation(
            "hanan",
            "",
            ""
        )
        assertThat(result).isFalse();

    }
    @Test
    fun `good job  ` (){
        val result = testRegistration.validation(
            "jaafar",
            "123",
            "123"
        )
        assertThat(result).isTrue();

    }

}