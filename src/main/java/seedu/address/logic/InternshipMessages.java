package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.internship.Internship;

/**
 * Container for user visible messages.
 */
public class InternshipMessages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_INTERNSHIP_DISPLAYED_INDEX = "Index has to be a positive number "
            + "(1,2,3...) and one of the displayed internship indexes.";
    public static final String MESSAGE_INVALID_TASK_DISPLAYED_INDEX = "Task index has to be a positive number "
            + "(1,2,3...) and one of the displayed task indexes of the internship.";
    public static final String MESSAGE_INTERNSHIPS_LISTED_OVERVIEW = "%1$d internships listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
            "Multiple values specified for the following single-valued field(s): ";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code internship} for display to the user.
     */
    public static String format(Internship internship) {
        final StringBuilder builder = new StringBuilder();
        builder.append("\nCompany Name: ")
                .append(internship.getCompanyName())
                .append("\n");
        builder.append("\nDescription: ")
                .append(internship.getDescription())
                .append("\n");

        builder.append("\nContact Name: ")
                .append(internship.getContactName())
                .append("\n");
        builder.append("\nContact Email: ")
                .append(internship.getContactEmail())
                .append("\n");
        builder.append("\nContact Number: ")
                .append(internship.getContactNumber())
                .append("\n");
        builder.append("\nApplication Status: ")
                .append(internship.getApplicationStatus())
                .append("\n");
        builder.append("\nRemark: ")
                .append(internship.getRemark())
                .append("\n");
        builder.append("\nTask List: ")
                .append(internship.getTaskList())
                .append("\n");
        internship.getLocation().ifPresent(location ->
                builder.append("Location: ").append(location));
        internship.getRole().ifPresent(role ->
                builder.append("Role: ").append(role));

        return builder.toString();
    }

}
