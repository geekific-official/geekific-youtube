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

package com.youtube.geekific.infra.repos;

import com.youtube.geekific.app.Video;
import com.youtube.geekific.infra.IRepository;
import com.youtube.geekific.infra.VideoEntity;
import com.youtube.geekific.infra.mapper.IVideoJpaMapper;
import com.youtube.geekific.infra.mapper.VideoJpaMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository("in-memory")
public class InMemoryVideoRepository implements IRepository {

    private final IVideoJpaMapper mapper = new VideoJpaMapper();
    private final Map<Long, VideoEntity> videos = new HashMap<>();

    @Override
    public Video save(Video entity) {
        VideoEntity jpaEntity = mapper.toJpaEntity(entity);
        videos.put(jpaEntity.getId(), jpaEntity);
        return mapper.toDomainEntity(videos.get(jpaEntity.getId()));
    }

    @Override
    public Optional<Video> findById(Long id) {
        return Optional.ofNullable(mapper.toDomainEntity(videos.get(id)));
    }

    @Override
    public Optional<Video> findByTitle(String title) {
        return videos.values().stream()
                .filter(video -> video.getTitle().equals(title))
                .map(mapper::toDomainEntity)
                .findFirst();
    }

}
