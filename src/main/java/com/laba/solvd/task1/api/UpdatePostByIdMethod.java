package com.laba.solvd.task1.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/posts/${id}", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/_put/put_post.json")
@ResponseTemplatePath(path = "api/_put/put_post.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class UpdatePostByIdMethod extends AbstractApiMethodV2 {
    public UpdatePostByIdMethod(long id) {
        replaceUrlPlaceholder("id", String.valueOf(id));

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }

}
