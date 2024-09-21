package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.ArrayList;
import java.util.List;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {

    /**
     * Parses the arguments in the context of the DeleteCommand and returns a DeleteCommand object for execution.
     * Accepts both single and multiple indices (e.g., "delete 5" or "delete 5,6,7").
     *
     * @throws ParseException if the user input does not conform to the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {
        try {
            // Split the input by commas to handle both single and multiple indices
            String[] parts = args.split(",");

            // List to store parsed indices
            List<Index> indices = new ArrayList<>();

            // Parse each part as an index
            for (String part : parts) {
                Index index = ParserUtil.parseIndex(part.trim());  // Trim to remove any extra spaces
                indices.add(index);
            }

            // Return a new DeleteCommand with the list of indices
            return new DeleteCommand(indices);

        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE), pe);
        }
    }


}
