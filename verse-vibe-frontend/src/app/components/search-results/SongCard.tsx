import { Song } from '@/app/models/models';
import { ExplicitOutlined, OpenInNew as OpenInNewIcon } from '@mui/icons-material';
import { Button, Card, CardContent, CardMedia, Typography } from '@mui/material';
import styles from './SongCard.module.css';

export default function SongCard({ song }: { song: Song }) {
  let imageUrl = '/src/assets/no-image-placeholder.svg';
  const albumImage = song.album.images.find((image) => image.width === 300 && image.height === 300);
  if (albumImage) {
    imageUrl = albumImage.url;
  }

  return (
    <Card className={styles.card}>
      <CardMedia className={styles.image} component="img" image={imageUrl} alt={song.name} />

      <CardContent className={styles.content}>
        <Typography variant="h6" className={styles.title}>
          {song.explicit && (<ExplicitOutlined />)}
          {song.explicit && ' '}
          {song.name}
        </Typography>

        <Typography variant="body2" className={styles.text}>
          <strong>Artists: </strong>
          {song.artists.map((artist, index) => (
            <a
              key={artist.spotifyId}
              href={artist.spotifyUrl}
              target="_blank"
              rel="noopener noreferrer"
              className={styles.artistLink}
            >
              {artist.name}
              {index < song.artists.length - 1 ? ', ' : ''}
            </a>
          ))}
        </Typography>

        <Typography variant="body2" className={styles.text}>
          <strong>Album:</strong> {song.album.name}
        </Typography>

        <Typography variant="body2" className={styles.text}>
          <strong>Release Year:</strong> {song.album.releaseDate}
        </Typography>

        <Typography variant="body2" className={styles.text}>
          <strong>Duration:</strong> {song.duration}
        </Typography>
      </CardContent>

      <Button className={styles.spotifyButton} href={song.spotifyUrl} target="_blank" rel="noopener noreferrer">
        Open in Spotify
        <OpenInNewIcon />
      </Button>
    </Card>
  );
}
