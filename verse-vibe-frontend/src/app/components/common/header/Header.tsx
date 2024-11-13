import { AppBar, Typography, Toolbar } from "@mui/material";
import styles from "./Header.module.css";

export default function Header() {
  return (
    <AppBar position="static" className={styles["app-bar"]}>
      <Toolbar className={styles.toolbar}>
        <Typography variant="h1" component="div" className={styles.title}>
          VerseVibe
        </Typography>
      </Toolbar>
    </AppBar>
  );
}
