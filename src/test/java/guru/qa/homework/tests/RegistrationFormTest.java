package guru.qa.homework.tests;

import guru.qa.homework.helpers.TestDate;
import guru.qa.homework.helpers.Utils;
import guru.qa.homework.pages.Gender;
import guru.qa.homework.pages.Hobbies;
import guru.qa.homework.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

public class RegistrationFormTest extends BaseTest {

  RegistrationFormPage registrationFormPage = new RegistrationFormPage();
  TestDate testDate = new TestDate();

  @Test
  public void submitFormWithValidData() {
    registrationFormPage
        .openPage()
        .typeFirstName(testDate.getFirstName())
        .typeLastName(testDate.getLastName())
        .typeEmailName(testDate.getEmail())
        .selectGender(Gender.MALE)
        .typePhoneNumber(testDate.getPhoneNumber())
        .selectBirthDate(testDate.getBirthDate())
        .typeSubject(TestDate.SUBJECT)
        .selectHobbies(Hobbies.READING)
        .uploadFile(TestDate.IMAGE_NAME)
        .typeAddress(testDate.getAddress())
        .selectStateAndCity(TestDate.STATE, TestDate.CITY)
        .clickSubmit()
        .assertField("Student Name", testDate.getFirstName() + " " + testDate.getLastName())
        .assertField("Student Email", testDate.getEmail())
        .assertField("Gender", Gender.MALE.name())
        .assertField("Mobile", testDate.getPhoneNumber())
        .assertField("Date of Birth",
            Utils.formatDate(testDate.getBirthDate(), "dd MMMM,yyyy", "en"))
        .assertField("Subjects", TestDate.SUBJECT)
        .assertField("Hobbies", Hobbies.READING.name())
        .assertField("Picture", TestDate.IMAGE_NAME)
        .assertField("Address", testDate.getAddress())
        .assertField("State and City", TestDate.STATE + " " + TestDate.CITY);
  }

}
