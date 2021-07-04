Following are 7 popular unit tests naming conventions that are found to be used by majority of developers and compiled from above pages:

1. MethodName_StateUnderTest_ExpectedBehavior: There are arguments against this strategy that if method names change as part of code refactoring than test name like this should also change or it becomes difficult to comprehend at a later stage.
   Following are some of the example:
    + isAdult_AgeLessThan18_False
    + withdrawMoney_InvalidAccount_ExceptionThrown
    + admitStudent_MissingMandatoryFields_FailToAdmit
   
2. MethodName_ExpectedBehavior_StateUnderTest: Slightly tweeked from above, but a section of developers also recommend using this naming technique. This technique also has disadvantage that if method names get changed, it becomes difficult to comprehend at a later stage. 
   Following is how tests in first example would read like if named using this technique:
    + isAdult_False_AgeLessThan18
    + withdrawMoney_ThrowsException_IfAccountIsInvalid
    + admitStudent_FailToAdmit_IfMandatoryFieldsAreMissing

3. test[Feature being tested]: This one makes it easy to read the test as the feature to be tested is written as part of test name. Although, there are arguments that the “test” prefix is redundant. However, some sections of developer love to use this technique. 
   Following is how the above tests would read like if named using this technique:
    + testIsNotAnAdultIfAgeLessThan18
    + testFailToWithdrawMoneyIfAccountIsInvalid
    + testStudentIsNotAdmittedIfMandatoryFieldsAreMissing

4. Feature to be tested: Many suggests that it is better to simply write the feature to be tested because one is anyway using annotations to identify method as test methods. It is also recommended for the reason that it makes unit tests as alternate form of documentation and avoid code smells. 
   Following is how tests in first example would read like if named using this technique:
    + IsNotAnAdultIfAgeLessThan18
    + FailToWithdrawMoneyIfAccountIsInvalid
    + StudentIsNotAdmittedIfMandatoryFieldsAreMissing

5. Should_ExpectedBehavior_When_StateUnderTest: This technique is also used by many as it makes it easy to read the tests. 
   Following is how tests in first example would read like if named using this technique:
    + Should_ThrowException_When_AgeLessThan18
    + Should_FailToWithdrawMoney_ForInvalidAccount
    + Should_FailToAdmit_IfMandatoryFieldsAreMissing

6. When_StateUnderTest_Expect_ExpectedBehavior: 
   Following is how tests in first example would read like if named using this technique:
    + When_AgeLessThan18_Expect_isAdultAsFalse
    + When_InvalidAccount_Expect_WithdrawMoneyToFail
    + When_MandatoryFieldsAreMissing_Expect_StudentAdmissionToFail

7. Given_Preconditions_When_StateUnderTest_Then_ExpectedBehavior: 
   This approach is based on naming convention developed as part of Behavior-Driven Development (BDD). The idea is to break down the tests into three part such that one could come up with preconditions, state under test and expected behavior to be written in above format. 
   Following is how tests in first example would read like if named using this technique:
    + Given_UserIsAuthenticated_When_InvalidAccountNumberIsUsedToWithdrawMoney_Then_TransactionsWillFail

My personal favorite is naming unit tests based on the writing features of the class under test. It helps me to make sure that a class follows single responsibility. It also aids a great deal in code refactoring.