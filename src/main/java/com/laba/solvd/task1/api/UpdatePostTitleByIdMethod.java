package com.laba.solvd.task1.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/posts/${id}", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/_patch/patch_post_rq.json")
@ResponseTemplatePath(path = "api/_patch/patch_post_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class UpdatePostTitleByIdMethod extends AbstractApiMethodV2 {
    public UpdatePostTitleByIdMethod(long id) {
        replaceUrlPlaceholder("id", String.valueOf(id));

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
