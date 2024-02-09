package com.laba.solvd.task1.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/posts", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/_post/post_post_rq.json")
@ResponseTemplatePath(path = "api/_post/post_post_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class CreatePostMethod extends AbstractApiMethodV2 {
    public CreatePostMethod() {
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
