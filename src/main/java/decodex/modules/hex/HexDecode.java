package decodex.modules.hex;

import decodex.data.Data;
import decodex.modules.BaseModule;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HexDecode extends BaseModule {

    public static final String MODULE_NAME = "hex-decode";

    public static final String MODULE_DESCRIPTION = "Converts a hexadecimal string back into its raw value";
    public static final String MODULE_EXAMPLE = "\"74 61 6b 6f 79 61 6b 69\" becomes \"takoyaki\"";

    public HexDecode() {
        super(MODULE_NAME, MODULE_DESCRIPTION);

    }

    /**
     * Decodes the given hexadecimal string back into its raw value.
     *
     * @param data Data object to be decoded.
     * @return new Data object representing the decoded input.
     */
    @Override
    public Data run(Data data) {
        String inputString = data.toString();
        inputString = inputString.replace(" ", "");

        String DecodedString = Arrays
                .stream(inputString.split("(?<=\\G..)"))
                .map(s -> Character.toString((char) Integer.parseInt(s, 16)))
                .collect(Collectors.joining());

        return new Data(DecodedString);
    }
}
