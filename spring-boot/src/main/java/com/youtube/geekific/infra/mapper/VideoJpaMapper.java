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

package com.youtube.geekific.infra.mapper;

import com.youtube.geekific.app.Video;
import com.youtube.geekific.infra.VideoEntity;
import com.youtube.geekific.infra.VideoEntity.VideoEntityBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class VideoJpaMapper implements IVideoJpaMapper {

    @Override
    public Video toDomainEntity(VideoEntity video) {
        return Video.builder()
                .id(String.valueOf(video.getId()))
                .title(video.getTitle())
                .author(video.getAuthor())
                .description(video.getDescription())
                .likes(video.getLikes())
                .duration(LocalTime.ofSecondOfDay(video.getDurationInSeconds()))
                .build();
    }

    @Override
    public VideoEntity toJpaEntity(Video video) {
        return StringUtils.isEmpty(video.getId()) ? newEntity(video) : mappedEntity(video);
    }

    private VideoEntity newEntity(Video video) {
        return getDefaultJpaEntity(video).creationDate(LocalDateTime.now()).build();
    }

    private VideoEntity mappedEntity(Video video) {
        return getDefaultJpaEntity(video).id(Long.parseLong(video.getId())).build();
    }

    private static VideoEntityBuilder getDefaultJpaEntity(Video video) {
        return VideoEntity.builder()
                .title(video.getTitle())
                .author(video.getAuthor())
                .description(video.getDescription())
                .likes(video.getLikes())
                .durationInSeconds(video.getDuration().toSecondOfDay());
    }

}
