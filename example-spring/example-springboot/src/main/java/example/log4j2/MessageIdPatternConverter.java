package example.log4j2;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.core.pattern.PatternConverter;

/**
 * Created by liyinhao on 2020/4/3.
 */
@Plugin(name = "MessageIdPatternConverter", category = PatternConverter.CATEGORY)
@ConverterKeys({"cat", "_cat"})
public class MessageIdPatternConverter extends LogEventPatternConverter {
    private static final MessageIdPatternConverter INSTANCE =
            new MessageIdPatternConverter();

    public static MessageIdPatternConverter newInstance(
            final String[] options) {
        return INSTANCE;
    }

    private MessageIdPatternConverter() {
        super("aaa", "aaa");
    }

    @Override
    public void format(LogEvent event, StringBuilder toAppendTo) {
        toAppendTo.append("here_is_messsageId");
    }
}
