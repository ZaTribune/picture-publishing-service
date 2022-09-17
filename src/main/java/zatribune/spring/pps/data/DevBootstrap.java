package zatribune.spring.pps.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import zatribune.spring.pps.data.entities.*;
import zatribune.spring.pps.data.repositories.PicRepository;
import zatribune.spring.pps.data.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    private final PicRepository picRepository;

    @Autowired
    public DevBootstrap(UserRepository userRepository, PicRepository picRepository) {
        log.debug(getClass().getSimpleName() + ":I'm at the Bootstrap phase.");
        this.userRepository = userRepository;
        this.picRepository = picRepository;
    }

    @Override
    public void onApplicationEvent(@Nullable ContextRefreshedEvent contextRefreshedEvent) {
        clearOldData();
        initData();
    }

    void clearOldData() {
        userRepository.deleteAll();
        picRepository.deleteAll();
    }

    @Transactional
    void initData() {
        log.info("initData()");

        Pic pic1 = new Pic();
        pic1.setCategory(PicCategory.LIVING_THING);
        pic1.setPath("cat.png");
        pic1.setStatus(PicStatus.APPROVED);
        pic1.setDescription("Be honest! it's better than a dog.");
        //pic1.setUser(user);

        Pic pic2 = new Pic();
        pic2.setCategory(PicCategory.MACHINE);
        pic2.setPath("f22.png");
        pic2.setStatus(PicStatus.APPROVED);
        pic2.setDescription("King Raptor is here, If you like it ,leave a comment below.\nOps!! no comment section available.");
        //pic2.setUser(user);

        Pic pic3 = new Pic();
        pic3.setCategory(PicCategory.NATURE);
        pic3.setPath("waterfall.png");
        pic3.setStatus(PicStatus.APPROVED);
        pic3.setDescription("Love is all, a waterfall.\npulls u in, takes u down.\nIt's a sad affair");

        Pic pic4 = new Pic();
        pic4.setCategory(PicCategory.NATURE);
        pic4.setPath("moon.gif");
        pic4.setStatus(PicStatus.PENDING);
        pic4.setDescription("Reminds u with something?!");

        Pic pic5 = new Pic();
        pic5.setCategory(PicCategory.MACHINE);
        pic5.setPath("megatron.png");
        pic5.setStatus(PicStatus.PENDING);
        pic5.setDescription("I'm megatron.");
        //pic3.setUser(user);

        AppUser admin = new AppUser();
        admin.setUsername("admin@pps.com");
        admin.setPassword("{pbkdf2.2018}1f1fab5f4176f86513f10136f70d4984ef97860490176f501843bb503489");//admin123
        admin.grantAuthority(Role.ADMIN);//user123

        AppUser appUser = new AppUser();
        appUser.setUsername("muhammad.ali@pps.com");
        appUser.setPassword("{pbkdf2.2018}5905ba87b762cad9626cbaa59777af0ef3a8bd5fdb08a4b0974cf8f5bb8f");//user123
        appUser.grantAuthority(Role.USER);//user123

        pic1.setAppUser(appUser);
        pic2.setAppUser(appUser);
        pic3.setAppUser(appUser);
        appUser.setPics(Set.of(pic1,pic2,pic3,pic4,pic5));

        //todo: we need the uploaded by

        userRepository.saveAll(List.of(admin, appUser));
    }
}
