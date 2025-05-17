package com.example.nonamehero.service;

import com.example.nonamehero.model.UserData;
import com.example.nonamehero.repository.UserDataRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class GameDataService {

    private final UserDataRepository repository;

    public GameDataService(UserDataRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserData saveOrUpdateUserData(UserData incoming) {
        if (incoming.getId() != null && repository.existsById(incoming.getId())) {
            // 1) DB에서 기존 엔티티 로드
            UserData existing = repository.findById(incoming.getId())
                    .orElseThrow();

            // 2) 필요한 필드들 덮어쓰기
            existing.setGold(incoming.getGold());
            existing.setLevel(incoming.getLevel());

            // 컬렉션은 클리어 후 덮어쓰기
            existing.getClearZone().clear();
            existing.getClearZone().addAll(incoming.getClearZone());

            existing.getOwnItems().clear();
            existing.getOwnItems().addAll(incoming.getOwnItems());

            existing.getPutOnItem().clear();
            existing.getPutOnItem().addAll(incoming.getPutOnItem());

            existing.getPutOnDress().clear();
            existing.getPutOnDress().addAll(incoming.getPutOnDress());

            // 3) 영속성 컨텍스트가 관리하는 existing이므로 save() 불러도 merge가 아닌 그냥 flush됩니다.
            return repository.save(existing);
        } else {
            // 새로 들어온 데이터는 바로 save → insert
            return repository.save(incoming);
        }
    }

    public UserData findUserDataById(Long id) {
        return repository.findById(id).orElse(null);
    }
}


