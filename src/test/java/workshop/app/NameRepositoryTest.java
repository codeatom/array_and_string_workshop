package workshop.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;


class NameRepositoryTest {
    String[] testArray = {"Christopher Ojaide", "Lucky Patrick", "Neri Ojaide", "Neri Christopher"};

    @BeforeEach
    void setup(){
        NameRepository.setNames(testArray);
    }

    @Test
    void should_Return_Names_Array_Size() {
        //Act
        int size = NameRepository.getSize();

        //Assert
        assertEquals(testArray.length, size);
    }

    @Test
    void should_Set_Names_Array() {
        //Act
        String[] nameArr = NameRepository.findAll();

        //Assert
        assertArrayEquals(testArray, nameArr);
    }

    @Test
    void should_Clear_Names_Array() {
        //Arrange
        String[] testResultArray = {};

        //Act
        NameRepository.clear();

        //Assert
        assertArrayEquals(testResultArray, NameRepository.findAll());
    }

    @Test
    void should_Return_All_Elements_Of_Names_Array() {
        //Act
        String[] nameArr = NameRepository.findAll();

        //Assert
        assertArrayEquals(testArray, nameArr);
    }

    @Test
    void should_Find_And_Return_An_Element_Of_Names_Array() {
        //Act
        String fullName = NameRepository.find("Lucky Patrick");

        //Assert
        assertEquals("Lucky Patrick", fullName);

    }

    @Test
    void should_Return_Null_When_Element_Of_Names_Array_Is_Not_Found() {
        //Act
        String fullName = NameRepository.find("Christopher Surname");

        //Assert
        assertNull(fullName);

    }

    @Test
    void should_Add_An_Element_To_Names_Array() {
        //Act
        boolean nameAdded = NameRepository.add("Chris Chris");

        //Assert
        assertAll(
                () -> assertTrue(nameAdded),
                () -> assertFalse(Arrays.equals(testArray, NameRepository.findAll()))
        );
    }

    @Test
    void should_Find_And_Return_An_Element_Of_Names_Array_Through_FirstName() {
        //Arrange
        String[] testResultArray = {"Neri Ojaide", "Neri Christopher",};

        //Act
        String[] nameArr = NameRepository.findByFirstName("Neri");

        //Assert
        assertArrayEquals(testResultArray, nameArr);
    }

    @Test
    void should_Find_And_Return_An_Element_Of_Names_Array_Through_LastName() {
        //Arrange
        String[] testResultArray = {"Christopher Ojaide", "Neri Ojaide",};

        //Act
        String[] nameArr = NameRepository.findByLastName("Ojaide");

        //Assert
        assertArrayEquals(testResultArray, nameArr);
    }

    @Test
    void should_Update_Names_Array() {
        //Arrange
        String[] testResultArray = {"Newman Lucky", "Lucky Patrick", "Neri Ojaide", "Neri Christopher"};

        //Act
        boolean nameUpdated = NameRepository.update("Christopher Ojaide", "Newman Lucky");

        //Assert
        assertAll(
                () -> assertTrue(nameUpdated),
                () -> assertArrayEquals(testArray, testResultArray)
        );
    }

    @Test
    void should_Remove_An_Element_From_Names() {
        //Arrange
        String[] testResultArray = {"Christopher Ojaide", "Neri Ojaide", "Neri Christopher"};

        //Act
        boolean nameRemoved = NameRepository.remove("Lucky Patrick");

        //Assert
        assertAll(
                () ->  assertTrue(nameRemoved),
                () -> assertArrayEquals(testResultArray, NameRepository.findAll())
        );
    }
}