package exceptions;

public enum ErrorMessages {

    MISSING_REQUIRED_FIELD("Missing required field. Please check documentation for required fields"),
    RECORD_ALREADY_EXISTS("Record already exists"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    NO_RECORD_FOUND("Record with provided id is not found"),
    COULD_NOT_UPDATE_RECORD("Could not update record"),
    COULD_NOT_DELETE_RECORD("Could not delete record"),
    EMPTY_FIELDS("Fields cannot be empty"),
    IMAGE_NOT_AVAILABLE("Image is not available"),
    CANNOT_BE_ZERO("Amount or Members cannot be 0"),
    FILE_PARSING_EXCEPTION("File uploading is corrupt or invalid");

    private final String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
