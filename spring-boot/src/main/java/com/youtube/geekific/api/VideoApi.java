/*
 * MIT License
 *
 * Copyright (c) 2024 Geekific (https://www.youtube.com/c/Geekific)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice, Geekific's channel link and this permission notice
 * shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.youtube.geekific.api;

import com.youtube.geekific.api.model.CreateVideoApiRequest;
import com.youtube.geekific.api.model.GetVideoApiResponse;
import com.youtube.geekific.api.model.LikeVideoApiResponse;
import com.youtube.geekific.app.exception.VideoNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/video")
public interface VideoApi {

    @Operation(
            summary = "Creates a video given its details",
            description = "Video created is added to the DB, title and author are required",
            hidden = false,
            deprecated = false,
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Video to create",
                    required = true,
                    content = @Content(schema = @Schema(implementation = CreateVideoApiRequest.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Video was created successfully"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error may be caused by..."),
            }
    )
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    String create(@RequestBody CreateVideoApiRequest request);

    @Operation(
            summary = "Adds a like to the provided video",
            description = "The id of the video is required, use the GET endpoint to retrieve it by title",
            parameters = {@Parameter(name = "id", description = "Id of the video to add a like to", required = true)},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Like was added successfully"),
                    @ApiResponse(responseCode = "404", description = "Video with provided Id was not found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error may be caused by..."),
            }
    )
    @PutMapping("/{id}")
    LikeVideoApiResponse like(@PathVariable String id) throws VideoNotFoundException;

    @Operation(
            summary = "Returns a video details given its title",
            description = "Video title must exist and is case-sensitive",
            parameters = {@Parameter(name = "title", description = "Title of the video to retrieve", required = true)},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Video was retrieved successfully by title"),
                    @ApiResponse(responseCode = "404", description = "Video was not found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error may be caused by..."),
            }
    )
    @GetMapping("/{title}")
    GetVideoApiResponse getByTitle(@PathVariable String title) throws VideoNotFoundException;

}
