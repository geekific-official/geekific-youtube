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

import com.youtube.geekific.api.mapper.IVideoApiMapper;
import com.youtube.geekific.api.model.CreateVideoApiRequest;
import com.youtube.geekific.api.model.GetVideoApiResponse;
import com.youtube.geekific.api.model.LikeVideoApiResponse;
import com.youtube.geekific.app.Video;
import com.youtube.geekific.app.exception.VideoNotFoundException;
import com.youtube.geekific.app.service.IVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class VideoController implements VideoApi {

    private final IVideoService service;
    private final IVideoApiMapper mapper;

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public String create(CreateVideoApiRequest request) {
        return service.createVideo(mapper.toDomainEntity(request));
    }

    @Override
    public LikeVideoApiResponse like(String id) throws VideoNotFoundException {
        Long likes = service.likeVideo(id);
        return mapper.toLikeVideoApiResponse(id, likes);
    }

    @Override
    public GetVideoApiResponse getByTitle(String title) throws VideoNotFoundException {
        Video video = service.getVideoByTitle(title);
        return mapper.toGetVideoApiResponse(video);
    }

    @ExceptionHandler(VideoNotFoundException.class)
    protected ResponseEntity<String> handleNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}



