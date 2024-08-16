package org.ssum.board.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ssum.board.entities.Board;
import org.ssum.board.entities.BoardData;
import org.ssum.board.repositories.BoardRepository;

@RequiredArgsConstructor
@Service
public class BoardDeleteService {

    private final BoardRepository repository;

    /**
     * 게시글 복구
     * - 삭제 일시 -> null
     *
     */

    public BoardData recover(Long seq) {
        BoardData item = infoService.get(seq);
        item.setDeletedAt(null);

        repository.saveAllAndFlush(item);

    }
}
