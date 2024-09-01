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

package com.youtube.geekific.app.service;

import com.youtube.geekific.app.Video;
import com.youtube.geekific.app.exception.VideoNotFoundException;
import com.youtube.geekific.infra.IRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoService implements IVideoService {

    @Qualifier("jpa")
    private final IRepository repository;

    @Override
    public String createVideo(Video video) {
        Video savedEntity = repository.save(video);
        return String.valueOf(savedEntity.getId());
    }

    @Override
    public Video getVideoByTitle(String title) throws VideoNotFoundException {
        Optional<Video> optionalVideo = repository.findByTitle(title);
        if (optionalVideo.isEmpty()) {
            throw new VideoNotFoundException(title);
        }
        return optionalVideo.get();
    }

    @Override
    public Long likeVideo(String id) throws VideoNotFoundException {
        Optional<Video> existingVideo = repository.findById(Long.valueOf(id));
        if (existingVideo.isEmpty()) {
            throw new VideoNotFoundException(id);
        }
        Video updatedVideo = existingVideo.get();
        updatedVideo.setLikes(updatedVideo.getLikes() + 1);
        repository.save(updatedVideo);
        return updatedVideo.getLikes();
    }

}


