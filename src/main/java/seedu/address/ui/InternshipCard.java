package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import seedu.address.model.internship.ApplicationStatus;
import seedu.address.model.internship.ApplicationStatus.StatusEnum;
import seedu.address.model.internship.CompanyName;
import seedu.address.model.internship.ContactEmail;
import seedu.address.model.internship.ContactName;
import seedu.address.model.internship.ContactNumber;
import seedu.address.model.internship.Description;
import seedu.address.model.internship.Internship;
import seedu.address.model.internship.Location;
import seedu.address.model.internship.Role;

/**
 * A UI component that displays information of a {@code Internship}.
 */
public class InternshipCard extends UiPart<Region> {

    private static final String FXML = "InternshipListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Internship internship;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label companyNameAndRole;
    @FXML
    private Label status;
    @FXML
    private Label description;
    @FXML
    private Label location;
    @FXML
    private Label poc;

    /**
     * Creates a {@code InternshipCard} with the given {@code Internship} and index to display.
     */
    public InternshipCard(Internship internship, int displayedIndex) {
        super(FXML);
        this.internship = internship;

        id.setText(displayedIndex + ". ");
        setCompanyNameAndRoleLabel(internship.getCompanyName(), internship.getRole());
        setStatusLabel(internship.getApplicationStatus());
        setDescriptionLabel(internship.getDescription());
        setLocationLabel(internship.getLocation());
        setPocLabel(internship.getContactName(), internship.getContactEmail(), internship.getContactNumber());
    }

    private void setPocLabel(ContactName contactName, ContactEmail contactEmail, ContactNumber contactNumber) {
        String stringToSet = "POC: " + contactName.toString() + " | "
                + contactEmail.toString() + " | " + contactNumber.toString();
        poc.setText(stringToSet);
    }

    private void setLocationLabel(Location loc) {
        location.setText(loc.toString());
    }

    private void setDescriptionLabel(Description desc) {
        description.setText(desc.toString());
    }
    private void setCompanyNameAndRoleLabel(CompanyName companyName, Role role) {
        String stringToSet = companyName.toString() + " -- " + role.toString();
        companyNameAndRole.setText(stringToSet);
    }
    private void setStatusLabel(ApplicationStatus applicationStatus) {
        status.setText(" * " + applicationStatus.toString());
        setStatusLabelColour(applicationStatus.applicationStatus);
    }
    private void setStatusLabelColour(StatusEnum statusEnum) {
        switch (statusEnum) {
        case TO_APPLY:
            status.setTextFill(Color.GREEN);
            break;
        case PENDING:
            status.setTextFill(Color.YELLOW);
            break;
        case REJECTED:
            status.setTextFill(Color.RED);
            break;
        case ACCEPTED:
            status.setTextFill(Color.CYAN);
            break;
        case ONGOING:
            status.setTextFill(Color.LIGHTSEAGREEN);
            break;
        default:
            throw new IllegalArgumentException("Unexpected application status: "
                    + internship.getApplicationStatus().applicationStatus);
        }
    }
}
