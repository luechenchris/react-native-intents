import * as React from 'react';
import { StyleSheet, View, Text } from 'react-native';
import Intents from 'react-native-intents';

export default function App() {
  const [result, setResult] = React.useState<Object | undefined>();

  React.useEffect(() => {
    Intents.getExtras().then(setResult);
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
