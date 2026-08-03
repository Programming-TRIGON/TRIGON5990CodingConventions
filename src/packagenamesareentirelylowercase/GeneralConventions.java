package packagenamesareentirelylowercase;

public class GeneralConventions {

    // =========================================================================
    // CONSTANTS:
    // A constant is a variable whose value cannot be changed once assigned and
    // belongs to the class itself rather than an instance. In Java, this is
    // achieved using both the 'static' and 'final' keywords.
    //
    // They should be used for values that are universally fixed throughout the
    // program's lifecycle, such as physical dimensions, fixed hardware ports,
    // or tuning values that shouldn't change at runtime.
    // =========================================================================

    // Similar constants should be logically grouped together with a single blank
    // line separating each group. This is especially important in SubsystemConstants.
    public static final int LEFT_INTAKE_MOTOR_ID = 1;
    public static final int RIGHT_INTAKE_MOTOR_ID = 2;

    public static final double COLLECTION_VOLTAGE = 5;
    public static final double EJECTION_VOLTAGE = -3;

    // =========================================================================
    // VARIABLE ORDERING & NAMING
    // 1. Static before non-static
    // 2. Final over non-final
    // 3. Access (public, protected, default, private)
    // 4. Importance
    //
    // Naming rules:
    // - ALL static variables (final or not) are UPPER_SNAKE_CASE.
    // - All other variables are lowerCamelCase.
    // - Boolean variables/methods must start with prefixes like "is" or "should".
    // =========================================================================

    public static final boolean IS_FOC_ENABLED = true;
    public static final int PUBLIC_STATIC_FINAL_VARIABLES_COME_FIRST = 1;
    protected static final int PROTECTED_ACCESS_COMES_AFTER_PUBLIC = 2;
    static final int DEFAULT_ACCESS_COMES_AFTER_PROTECTED = 3;
    private static final int PRIVATE_ACCESS_COMES_LAST_IN_ACCESS_MODIFIERS = 4;

    public static int STATIC_NON_FINAL_COMES_AFTER_STATIC_FINAL = 5;
    private static int PRIVATE_STATIC_NON_FINAL_COMES_AFTER_PUBLIC = 6;

    public final int nonStaticFinalComesAfterAllStaticVariables = 7;
    private final int privateNonStaticFinalComesAfterPublic = 8;

    public int nonStaticNonFinalComesAfterAllFinalVariables = 9;
    private int privateNonStaticNonFinalComesAfterPublic = 10;

    public int variableNamesShouldBeClearAndMeaningfulEvenIfTheyAreLong = 11;
    private boolean isVariableNamingClear = true;

    // =========================================================================
    // METHOD ORDERING & STRUCTURE
    // 1. Static methods
    // 2. Constructors
    // 3. Other methods
    // Within those: Access (public, protected, default, private)
    // Within access: Caller goes above callee (unless private calls public)
    // Finally: Importance
    //
    // Naming rules:
    // - Method names are lowerCamelCase.
    //
    // Spacing rules:
    // - There must be exactly one blank line (space) before and after each method.
    // - There should NEVER be more than one consecutive blank line anywhere.
    // =========================================================================

    public static void publicStaticMethodsGoBeforeConstructors() {
        final int variablesThatCanBeFinalInsideMethodsShouldBeFinal = 1;
    }

    public GeneralConventions() {
        // Constructor goes directly after static methods
    }

    public void methodNamesShouldBeClearAndMeaningfulEvenIfTheyAreLong() {
        // Method names should thoroughly explain what they do.
    }

    public boolean isOpen() {
        // Example of a properly named boolean method
        return isVariableNamingClear;
    }

    /**
     * Complex methods should have Javadocs explaining their logic and purpose.
     * This method demonstrates that public methods go before private methods,
     * and caller methods go above the methods they call.
     *
     * @param thisParameterIsNotFinal Method parameters should not be marked as final.
     */
    public void thisPublicMethodCallsAPrivateMethodBelowIt(int thisParameterIsNotFinal) {
        final int output = thisPrivateMethodIsCalledByTheMethodAboveIt(thisParameterIsNotFinal);
    }

    public void thisPublicMethodIsCalledByAPrivateMethodButStaysAboveItBecauseItIsPublic() {
        final boolean publicAccessOverridesTheCallerAboveCalleeRule = true;
    }

    private void largeBlocksOfCodeShouldBeSeparatedByBlankLinesWhereItMakesSense(int inputLimit) {
        // final variables can be the result of a calculation rather than a hardcoded constant
        final int calculatedLimit = thisPrivateMethodIsCalledByTheMethodAboveIt(inputLimit);
        int currentTotal = 0;

        for (int i = 0; i < calculatedLimit; i++)
            currentTotal += thisPrivateMethodIsCalledByTheMethodAboveIt(i);

        // The blank line above separates the looping logic from the validation logic below.
        // It makes the code easier to read by grouping related lines into "paragraphs".

        shortIfStatementsAndForLoopsOmitCurlyBrackets(currentTotal);
    }

    private void shortIfStatementsAndForLoopsOmitCurlyBrackets(int currentTotal) {
        // Demonstrating a final variable storing a calculated threshold, not just a static number
        final int calculationThreshold = currentTotal / 2;

        // Example of a short for-loop without curly brackets
        for (int i = 0; i < calculationThreshold; i++)
            thisPrivateMethodIsCalledByTheMethodAboveIt(i);

        // Example of a short if-statement without curly brackets
        if (calculationThreshold == PUBLIC_STATIC_FINAL_VARIABLES_COME_FIRST)
            thisPrivateMethodIsCalledByTheMethodAboveIt(calculationThreshold);
    }

    private void thisPrivateMethodExtractsSimilarLogicUsedInMultiplePlaces(int inputOne, int inputTwo) {
        // This caller is now correctly placed ABOVE the callee method below
        thisPrivateMethodIsCalledByTheMethodAboveIt(inputOne);
        thisPrivateMethodIsCalledByTheMethodAboveIt(inputTwo);

        thisPublicMethodIsCalledByAPrivateMethodButStaysAboveItBecauseItIsPublic();
    }

    private int thisPrivateMethodIsCalledByTheMethodAboveIt(int input) {
        return input * 2;
    }

    // =========================================================================
    // ENUMS
    // Names: UpperCamelCase
    // States: UPPER_SNAKE_CASE (Future tense)
    // =========================================================================

    public enum ExampleEnum {
        PREPARE,
        SCORE,
        PLACE,
        STOP
    }
}