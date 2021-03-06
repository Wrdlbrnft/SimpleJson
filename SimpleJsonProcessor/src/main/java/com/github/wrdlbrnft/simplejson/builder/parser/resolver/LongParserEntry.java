package com.github.wrdlbrnft.simplejson.builder.parser.resolver;

import com.github.wrdlbrnft.codebuilder.types.Types;
import com.github.wrdlbrnft.codebuilder.util.Utils;
import com.github.wrdlbrnft.codebuilder.variables.Field;
import com.github.wrdlbrnft.simplejson.SimpleJsonTypes;
import com.github.wrdlbrnft.simplejson.builder.ParserBuilder;
import com.github.wrdlbrnft.simplejson.builder.implementation.MappedValue;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.type.TypeMirror;

/**
 * Created with Android Studio<br>
 * User: Xaver<br>
 * Date: 03/02/2018
 */

class LongParserEntry extends BaseParserEntry {

    LongParserEntry(ProcessingEnvironment processingEnvironment, ParserBuilder.BuildCache buildCache) {
        super(processingEnvironment, buildCache);
    }

    @Override
    protected boolean matches(MappedValue value, TypeMirror type) {
        return Utils.isSameType(type, long.class) || Utils.isSameType(type, Long.class);
    }

    @Override
    protected String getKey(MappedValue value, TypeMirror type) {
        return "_long";
    }

    @Override
    protected Field createField(MappedValue value, TypeMirror type) {
        return createElementParserField(
                Types.generic(SimpleJsonTypes.ELEMENT_PARSER, Types.Boxed.LONG),
                SimpleJsonTypes.LONG_PARSER
        );
    }
}
