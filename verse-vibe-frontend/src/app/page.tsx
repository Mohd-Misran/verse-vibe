import Header from './components/common/header/Header';
import { Fragment } from 'react';
import ThemeWrapper from './theme/ThemeWrapper';
import Footer from './components/common/footer/Footer';

export default function Home() {
  return (
    <Fragment>
      <ThemeWrapper>
        <Header />
        <Footer />
      </ThemeWrapper>
    </Fragment>
  );
}
