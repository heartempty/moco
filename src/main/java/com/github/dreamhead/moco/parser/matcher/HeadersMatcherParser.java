package com.github.dreamhead.moco.parser.matcher;

import com.github.dreamhead.moco.RequestMatcher;
import com.github.dreamhead.moco.parser.model.RequestSetting;
import com.google.common.base.Function;

import java.util.Map;

import static com.github.dreamhead.moco.Moco.eq;
import static com.github.dreamhead.moco.Moco.header;

public class HeadersMatcherParser extends AbstractCompositeMatcherParser {
    protected Map<String, String> getCollection(RequestSetting request) {
        return request.getHeaders();
    }

    protected Function<Map.Entry<String, String>, RequestMatcher> toTargetMatcher() {
        return new Function<Map.Entry<String, String>, RequestMatcher>() {
            @Override
            public RequestMatcher apply(Map.Entry<String, String> entry) {
                return eq(header(entry.getKey()), entry.getValue());
            }
        };
    }
}
