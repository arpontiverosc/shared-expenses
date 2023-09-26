package com.clean.architecture.sharedexpenses.user_groups.user_case;

import com.clean.architecture.sharedexpenses.user_groups.domain.model.User;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.DetailUserUseCase;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.in.model.DetailUserQuery;
import com.clean.architecture.sharedexpenses.user_groups.domain.port.out.FindUserByIdRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DetailUserUseCaseImpl implements DetailUserUseCase {
    sacar esto a un servicio
    private final FindUserByIdRepository findUserByIdRepository;
    @Transactional(readOnly = true)
    @Override
    public User execute(DetailUserQuery query) {
        return findUserByIdRepository.findById(query.getId()).orElseThrow(UserNotFoundException::new);
    }
}
