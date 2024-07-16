package site.metacoding.blogv3.Community;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.metacoding.blogv3.user.User;

@Service
@RequiredArgsConstructor
public class CommService {
    private final CommRepository commRepository;

    public void saveComm(User user, CommRequest.CommDTO commDTO) {

        Comm comm = new Comm();
        comm.setUser(user);
        comm.setTitle(commDTO.getTitle());
        comm.setContent(commDTO.getContent());

        commRepository.save(comm);
    }
}
