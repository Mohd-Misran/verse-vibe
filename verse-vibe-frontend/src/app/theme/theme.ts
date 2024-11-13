import { createTheme } from '@mui/material';

const theme = createTheme({
  palette: {
    mode: 'light',
    background: {
      default: 'var(--background)',
    },
    text: {
      primary: 'var(--foreground)',
    },
    primary: {
      main: '#1db954',
    },
    secondary: {
      main: '#121212',
    },
  },
  typography: {
    fontFamily: 'Arial, Helvetica, sans-serif',
    fontSize: 16,
  },
});

export default theme;
