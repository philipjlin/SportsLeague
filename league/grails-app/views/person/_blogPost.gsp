<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<div class="container">

    <g:set var="blogPost" value="${bean}"/>

    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div>Text</div>
            <div> ${blogPost.text} </div>
            <br>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div>Date Published</div>
            <div>${blogPost.datePublished}</div>
            <br>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div>Comments</div>
            <g:each var="comment" in="${blogPost.comments}">
                ${comment.text}
                ${comment.dateCreated}

                <g:each var="reply" in="${blogPost.comments.replies}">
                    ${reply.text}
                    ${reply.dateCreated}
                </g:each>

                <g:form controller="BlogEntry" params="[commentId:comment.id]">
                    <label>Reply to Comment</label>
                    <g:textField name="text"/><br/>
                    <g:actionSubmit value="Post Reply" action="addReplyToComment"/>
                </g:form>
                <br>
            </g:each>
        </div>
    </div>

</div>