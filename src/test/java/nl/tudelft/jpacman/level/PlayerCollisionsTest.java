package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.sprite.Sprite;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class PlayerCollisionsTest {

    @Test
    void testCollisionPlayerAndGhost() {
        PacManSprites pacManSprites = new PacManSprites();
        PlayerFactory playerFactory = new PlayerFactory(pacManSprites);
        Player player = playerFactory.createPacMan();

        PacManSprites pacManSprites1 = new PacManSprites();
        GhostFactory ghostFactory = new GhostFactory(pacManSprites1);
        Ghost blinky = ghostFactory.createBlinky();

        PlayerCollisions playerCollision = new PlayerCollisions(new DefaultPointCalculator());
        playerCollision.collide(player, blinky);

        assertThat(!player.isAlive());
        assertThat(player.getKiller() == blinky);
    }

    @Test
    void testCollisionPlayerAndPellet() {
        PacManSprites pacManSprites = new PacManSprites();
        PlayerFactory playerFactory = new PlayerFactory(pacManSprites);
        Player player = playerFactory.createPacMan();

        PlayerCollisions playerCollision = new PlayerCollisions(new DefaultPointCalculator());
        Sprite sprite = mock(Sprite.class);
        Pellet pellet = new Pellet(1, sprite);

        playerCollision.collide(player, pellet );
        assertThat(player.getScore() == 1);

    }

}
