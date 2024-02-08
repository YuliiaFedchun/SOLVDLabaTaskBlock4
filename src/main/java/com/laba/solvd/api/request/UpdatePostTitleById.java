package com.laba.solvd.api.request;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/posts/${id}", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/_patch/patch_post_rq.json")
@ResponseTemplatePath(path = "api/_patch/patch_post_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class UpdatePostTitleById extends AbstractApiMethodV2 {
    public UpdatePostTitleById(long id) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("id", String.valueOf(id));

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
